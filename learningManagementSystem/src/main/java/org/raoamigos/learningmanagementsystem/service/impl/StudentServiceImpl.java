package org.raoamigos.learningmanagementsystem.service.impl;

import org.modelmapper.ModelMapper;
import org.raoamigos.learningmanagementsystem.dto.StudentRequestDTO;
import org.raoamigos.learningmanagementsystem.dto.StudentResponseDTO;
import org.raoamigos.learningmanagementsystem.entity.Student;
import org.raoamigos.learningmanagementsystem.exception.ResourceNotFoundException;
import org.raoamigos.learningmanagementsystem.repository.StudentRepository;
import org.raoamigos.learningmanagementsystem.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO dto) {
        Student student = modelMapper.map(dto, Student.class);
        Student saved  = studentRepository.save(student);

        return modelMapper.map(saved, StudentResponseDTO.class );
    }

    @Override
    public StudentResponseDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));

        return modelMapper.map(student, StudentResponseDTO.class );
    }

    @Override
    public Page<StudentResponseDTO> getAllStudents(Pageable pageable) {
        Page<Student> students = studentRepository.findAll(pageable);

        return students.map(student -> modelMapper.map(student, StudentResponseDTO.class));
    }

    @Override
    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setPhone(dto.getPhone());

        Student updated = studentRepository.save(student);

        return modelMapper.map(updated, StudentResponseDTO.class);
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student","id",id));

        studentRepository.delete(student);
    }
}
