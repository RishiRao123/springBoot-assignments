package org.raoamigos.learningmanagementsystem.service;

import org.raoamigos.learningmanagementsystem.dto.CourseRequestDTO;
import org.raoamigos.learningmanagementsystem.dto.CourseResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {

    CourseResponseDTO createCourse(CourseRequestDTO dto);

    CourseResponseDTO getCourseById(Long id);

    Page<CourseResponseDTO> getAllCourses(Pageable pageable);

    CourseResponseDTO updateCourse(Long id, CourseRequestDTO dto);

    void deleteCourse(Long id);
}
