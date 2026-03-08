package org.raoamigos.learningmanagementsystem.service;

import org.raoamigos.learningmanagementsystem.dto.StudentRequestDTO;
import org.raoamigos.learningmanagementsystem.dto.StudentResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {

    StudentResponseDTO createStudent(StudentRequestDTO dto);

    StudentResponseDTO getStudentById(Long id);

    Page<StudentResponseDTO> getAllStudents(Pageable pageable);

    StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto);

    void deleteStudent(Long id);
}
