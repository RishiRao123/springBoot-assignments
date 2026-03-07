package org.raoamigos.coursemanagementsystem.service.impl;


import org.modelmapper.ModelMapper;
import org.raoamigos.coursemanagementsystem.dto.CourseRequestDTO;
import org.raoamigos.coursemanagementsystem.dto.CourseResponseDTO;
import org.raoamigos.coursemanagementsystem.entity.Course;
import org.raoamigos.coursemanagementsystem.repository.CourseRepository;
import org.raoamigos.coursemanagementsystem.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    public CourseServiceImpl(CourseRepository courseRepository, ModelMapper modelMapper) {
        this.courseRepository = courseRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO dto) {
        Course course = modelMapper.map(dto, Course.class);
        Course savedCourse = courseRepository.save(course);

        return modelMapper.map(savedCourse, CourseResponseDTO.class);
    }

    @Override
    public List<CourseResponseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(c -> modelMapper.map(c, CourseResponseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CourseResponseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        return modelMapper.map(course, CourseResponseDTO.class);
    }

    @Override
    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO dto) {
        Course course = courseRepository.findById(id)
                            .orElseThrow(() -> new RuntimeException("Course not found"));

        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setInstructor(dto.getInstructor());
        course.setDuration(dto.getDuration());
        course.setPrice(dto.getPrice());

        Course updatedCourse = courseRepository.save(course);

        return modelMapper.map(updatedCourse, CourseResponseDTO.class);
    }

    @Override
    public void deleteCourse(Long id) {
        Course course =  courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        courseRepository.delete(course);
    }
}
