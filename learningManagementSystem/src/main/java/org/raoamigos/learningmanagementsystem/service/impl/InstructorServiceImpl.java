package org.raoamigos.learningmanagementsystem.service.impl;

import org.modelmapper.ModelMapper;
import org.raoamigos.learningmanagementsystem.dto.InstructorRequestDTO;
import org.raoamigos.learningmanagementsystem.dto.InstructorResponseDTO;
import org.raoamigos.learningmanagementsystem.entity.Instructor;
import org.raoamigos.learningmanagementsystem.exception.ResourceNotFoundException;
import org.raoamigos.learningmanagementsystem.repository.InstructorRepository;
import org.raoamigos.learningmanagementsystem.service.InstructorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final ModelMapper modelMapper;

    public InstructorServiceImpl(InstructorRepository instructorRepository, ModelMapper modelMapper) {
        this.instructorRepository = instructorRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public InstructorResponseDTO createInstructor(InstructorRequestDTO dto) {
        Instructor instructor = modelMapper.map(dto, Instructor.class);
        Instructor saved = instructorRepository.save(instructor);

        return modelMapper.map(saved, InstructorResponseDTO.class);
    }

    @Override
    public InstructorResponseDTO getInstructorById(Long id) {
        Instructor instructor = instructorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor", "id", id));

        return modelMapper.map(instructor, InstructorResponseDTO.class);
    }

    @Override
    public Page<InstructorResponseDTO> getAllInstructors(Pageable pageable) {
        Page<Instructor> instructors = instructorRepository.findAll(pageable);

        return instructors.map(instructor -> modelMapper.map(instructor, InstructorResponseDTO.class));
    }

    @Override
    public InstructorResponseDTO updateInstructor(Long id, InstructorRequestDTO dto) {
        Instructor instructor = instructorRepository.findById(id)
                                    .orElseThrow(() -> new ResourceNotFoundException("Instructor", "id", id));

        instructor.setName(dto.getName());
        instructor.setEmail(dto.getEmail());
        instructor.setExpertise(dto.getExpertise());

        Instructor updated = instructorRepository.save(instructor);

        return modelMapper.map(updated, InstructorResponseDTO.class);
    }

    @Override
    public void deleteInstructor(Long id) {

    }
}
