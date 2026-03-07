package org.raoamigos.coursemanagementsystem.service;

import org.springframework.data.domain.Page;
import org.raoamigos.coursemanagementsystem.dto.CourseRequestDTO;
import org.raoamigos.coursemanagementsystem.dto.CourseResponseDTO;


public interface CourseService {

    CourseResponseDTO createCourse(CourseRequestDTO dto);

    Page<CourseResponseDTO> getAllCourses(int page, int size, String sortBy);

    CourseResponseDTO getCourseById(Long id);

    CourseResponseDTO updateCourse(Long id, CourseRequestDTO dto);

    void deleteCourse(Long id);

}
