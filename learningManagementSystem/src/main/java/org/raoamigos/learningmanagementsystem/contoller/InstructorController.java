package org.raoamigos.learningmanagementsystem.contoller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.raoamigos.learningmanagementsystem.dto.InstructorRequestDTO;
import org.raoamigos.learningmanagementsystem.dto.InstructorResponseDTO;
import org.raoamigos.learningmanagementsystem.payload.ApiResponse;
import org.raoamigos.learningmanagementsystem.service.InstructorService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @PostMapping
    public ResponseEntity<ApiResponse<InstructorResponseDTO>> createInstructor(
            @Valid @RequestBody InstructorRequestDTO dto) {

        InstructorResponseDTO created = instructorService.createInstructor(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "Instructor created successfully", created));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<InstructorResponseDTO>>> getAllInstructors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<InstructorResponseDTO> instructors = instructorService.getAllInstructors(pageable);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Instructors fetched successfully", instructors)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<InstructorResponseDTO>> getInstructorById(@PathVariable Long id) {

        InstructorResponseDTO instructor = instructorService.getInstructorById(id);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Instructor fetched successfully", instructor)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<InstructorResponseDTO>> updateInstructor(
            @PathVariable Long id,
            @Valid @RequestBody InstructorRequestDTO dto) {

        InstructorResponseDTO updated = instructorService.updateInstructor(id, dto);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Instructor updated successfully", updated)
        );
    }
}