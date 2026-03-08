package org.raoamigos.learningmanagementsystem.contoller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.raoamigos.learningmanagementsystem.dto.StudentRequestDTO;
import org.raoamigos.learningmanagementsystem.dto.StudentResponseDTO;
import org.raoamigos.learningmanagementsystem.payload.ApiResponse;
import org.raoamigos.learningmanagementsystem.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<ApiResponse<StudentResponseDTO>> createStudent(
            @Valid @RequestBody StudentRequestDTO dto) {

        StudentResponseDTO created = studentService.createStudent(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "Student created successfully", created));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponseDTO>> getStudentById(@PathVariable Long id) {

        StudentResponseDTO student = studentService.getStudentById(id);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Student fetched successfully", student)
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<StudentResponseDTO>>> getAllStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        Page<StudentResponseDTO> students = studentService.getAllStudents(pageable);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Students fetched successfully", students)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponseDTO>> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentRequestDTO dto) {

        StudentResponseDTO updated = studentService.updateStudent(id, dto);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Student updated successfully", updated)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteStudent(@PathVariable Long id) {

        studentService.deleteStudent(id);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Student deleted successfully", null)
        );
    }
}