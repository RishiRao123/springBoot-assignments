package org.raoamigos.learningmanagementsystem.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.raoamigos.learningmanagementsystem.dto.EnrollmentRequestDTO;
import org.raoamigos.learningmanagementsystem.dto.EnrollmentResponseDTO;
import org.raoamigos.learningmanagementsystem.entity.Course;
import org.raoamigos.learningmanagementsystem.entity.Enrollment;
import org.raoamigos.learningmanagementsystem.entity.Student;
import org.raoamigos.learningmanagementsystem.exception.ResourceNotFoundException;
import org.raoamigos.learningmanagementsystem.repository.CourseRepository;
import org.raoamigos.learningmanagementsystem.repository.EnrollmentRepository;
import org.raoamigos.learningmanagementsystem.repository.StudentRepository;
import org.raoamigos.learningmanagementsystem.service.EnrollmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Override
    public EnrollmentResponseDTO createEnrollment(EnrollmentRequestDTO dto) {
        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", dto.getStudentId()));
        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", dto.getCourseId()));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);

        return modelMapper.map(savedEnrollment, EnrollmentResponseDTO.class);
    }

    @Override
    public EnrollmentResponseDTO getEnrollmentById(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment", "id", id));

        return modelMapper.map(enrollment, EnrollmentResponseDTO.class);
    }

    @Override
    public List<EnrollmentResponseDTO> getEnrollmentsByStudent(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId)
                .stream()
                .map(s -> modelMapper.map(s, EnrollmentResponseDTO.class))
                .toList();
    }

    @Override
    public Page<EnrollmentResponseDTO> getAllEnrollments(Pageable pageable) {
        Page<Enrollment> enrollments = enrollmentRepository.findAll(pageable);

        return enrollments.map(student -> modelMapper.map(student, EnrollmentResponseDTO.class));

    }

    @Override
    public EnrollmentResponseDTO updateEnrollment(Long id, EnrollmentRequestDTO dto) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment", "id", id));
        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", dto.getStudentId()));
        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Course", "id", dto.getCourseId()));

        enrollment.setStudent(student);
        enrollment.setCourse(course);

        Enrollment updatedEnrollment = enrollmentRepository.save(enrollment);

        return modelMapper.map(updatedEnrollment, EnrollmentResponseDTO.class);
    }

    @Override
    public void deleteEnrollment(Long id) {
        Enrollment enrollment = enrollmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment", "id", id));

        enrollmentRepository.delete(enrollment);
    }
}
