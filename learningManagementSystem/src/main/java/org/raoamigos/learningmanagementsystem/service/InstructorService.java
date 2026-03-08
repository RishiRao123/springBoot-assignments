package org.raoamigos.learningmanagementsystem.service;

import org.raoamigos.learningmanagementsystem.dto.InstructorRequestDTO;
import org.raoamigos.learningmanagementsystem.dto.InstructorResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InstructorService {

    InstructorResponseDTO createInstructor(InstructorRequestDTO dto);

    InstructorResponseDTO getInstructorById(Long id);

    Page<InstructorResponseDTO> getAllInstructors(Pageable pageable);

    InstructorResponseDTO updateInstructor(Long id, InstructorRequestDTO dto);

    void deleteInstructor(Long id);
}
