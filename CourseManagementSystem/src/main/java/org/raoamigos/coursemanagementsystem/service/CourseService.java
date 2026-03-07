package org.raoamigos.coursemanagementsystem.service;


import org.raoamigos.coursemanagementsystem.dto.CourseRequestDTO;
import org.raoamigos.coursemanagementsystem.dto.CourseResponseDTO;

import java.util.List;

public interface CourseService {

    CourseResponseDTO createCourse(CourseRequestDTO dto);

    List<CourseResponseDTO> getAllCourses();

    CourseResponseDTO getCourseById(Long id);

    CourseResponseDTO updateCourse(Long id, CourseRequestDTO dto);

    void deleteCourse(Long id);

}
