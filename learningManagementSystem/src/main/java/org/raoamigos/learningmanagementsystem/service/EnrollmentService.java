package org.raoamigos.learningmanagementsystem.service;

import org.raoamigos.learningmanagementsystem.dto.EnrollmentRequestDTO;
import org.raoamigos.learningmanagementsystem.dto.EnrollmentResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EnrollmentService {

    EnrollmentResponseDTO createEnrollment(EnrollmentRequestDTO dto);

    EnrollmentResponseDTO getEnrollmentById(Long id);

    List<EnrollmentResponseDTO> getEnrollmentsByStudent(Long studentId);

    Page<EnrollmentResponseDTO> getAllEnrollments(Pageable pageable);

    EnrollmentResponseDTO updateEnrollment(Long id, EnrollmentRequestDTO dto);

    void deleteEnrollment(Long id);
}