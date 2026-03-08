package org.raoamigos.learningmanagementsystem.contoller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.raoamigos.learningmanagementsystem.dto.EnrollmentRequestDTO;
import org.raoamigos.learningmanagementsystem.dto.EnrollmentResponseDTO;
import org.raoamigos.learningmanagementsystem.payload.ApiResponse;
import org.raoamigos.learningmanagementsystem.service.EnrollmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<ApiResponse<EnrollmentResponseDTO>> enrollStudent(
            @Valid @RequestBody EnrollmentRequestDTO dto) {

        EnrollmentResponseDTO enrollment = enrollmentService.createEnrollment(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "Student enrolled successfully", enrollment));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<EnrollmentResponseDTO>>> getAllEnrollments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<EnrollmentResponseDTO> enrollments = enrollmentService.getAllEnrollments(pageable);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Enrollments fetched successfully", enrollments)
        );
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<ApiResponse<List<EnrollmentResponseDTO>>> getEnrollmentsByStudent(
            @PathVariable Long studentId) {

        List<EnrollmentResponseDTO> enrollments =
                enrollmentService.getEnrollmentsByStudent(studentId);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Student enrollments fetched", enrollments)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteEnrollment(@PathVariable Long id) {

        enrollmentService.deleteEnrollment(id);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Enrollment cancelled successfully", null)
        );
    }
}