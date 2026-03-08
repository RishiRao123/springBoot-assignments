package org.raoamigos.learningmanagementsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.raoamigos.learningmanagementsystem.dto.CourseRequestDTO;
import org.raoamigos.learningmanagementsystem.dto.CourseResponseDTO;
import org.raoamigos.learningmanagementsystem.entity.Course;
import org.raoamigos.learningmanagementsystem.entity.Instructor;
import org.raoamigos.learningmanagementsystem.exception.ResourceNotFoundException;
import org.raoamigos.learningmanagementsystem.repository.CourseRepository;
import org.raoamigos.learningmanagementsystem.repository.InstructorRepository;
import org.raoamigos.learningmanagementsystem.service.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final InstructorRepository instructorRepository;
    private final ModelMapper modelMapper;


    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO dto) {

        Instructor instructor = instructorRepository.findById(dto.getInstructorId())
                .orElseThrow(() -> new ResourceNotFoundException("Instructor", "id", dto.getInstructorId()));

        Course course = new Course();
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setDuration(dto.getDuration());
        course.setPrice(dto.getPrice());
        course.setInstructor(instructor);

        Course savedCourse = courseRepository.save(course);

        CourseResponseDTO response = modelMapper.map(savedCourse, CourseResponseDTO.class);
        response.setInstructorName(savedCourse.getInstructor().getName());

        return response;
    }

    @Override
    public CourseResponseDTO getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));

        CourseResponseDTO dto = modelMapper.map(course, CourseResponseDTO.class);
        dto.setInstructorName(course.getInstructor().getName());

        return dto;
    }

    @Override
    public Page<CourseResponseDTO> getAllCourses(Pageable pageable) {
        Page<Course> page = courseRepository.findAll(pageable);

        return page.map(course -> {
            CourseResponseDTO dto = modelMapper.map(course, CourseResponseDTO.class);
            dto.setInstructorName(course.getInstructor().getName());
            return dto;
        });
    }

    @Override
    public CourseResponseDTO updateCourse(Long id, CourseRequestDTO dto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));
        Instructor instructor = instructorRepository.findById(dto.getInstructorId())
                        .orElseThrow(() -> new ResourceNotFoundException("Instructor", "id", dto.getInstructorId()));

        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setDuration(dto.getDuration());
        course.setPrice(dto.getPrice());
        course.setInstructor(instructor);

        Course updatedCourse = courseRepository.save(course);

        CourseResponseDTO response = modelMapper.map(updatedCourse, CourseResponseDTO.class);
        response.setInstructorName(updatedCourse.getInstructor().getName());

        return response;
    }

    @Override
    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
                            .orElseThrow(() -> new ResourceNotFoundException("Course", "id", id));

        courseRepository.delete(course);
    }
}
