package org.raoamigos.learningmanagementsystem.contoller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.raoamigos.learningmanagementsystem.dto.CourseRequestDTO;
import org.raoamigos.learningmanagementsystem.dto.CourseResponseDTO;
import org.raoamigos.learningmanagementsystem.payload.ApiResponse;
import org.raoamigos.learningmanagementsystem.service.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<ApiResponse<CourseResponseDTO>> createCourse(@Valid @RequestBody CourseRequestDTO dto) {
        CourseResponseDTO course = courseService.createCourse(dto);
        ApiResponse<CourseResponseDTO> response = new ApiResponse<>(true, "Course Created Successfully", course);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseResponseDTO>> getCourseById(@PathVariable Long id) {
        CourseResponseDTO course = courseService.getCourseById(id);
        ApiResponse<CourseResponseDTO> response = new ApiResponse<>(true, "Course Found Successfully", course);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<CourseResponseDTO>>> getAllCourses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "title") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        Page<CourseResponseDTO> courses = courseService.getAllCourses(pageable);

        return ResponseEntity.ok(new ApiResponse<>(true, "Courses Fetched Successfully", courses));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseResponseDTO>> updateCourse(@PathVariable Long id, @Valid @RequestBody CourseRequestDTO dto) {
        CourseResponseDTO course = courseService.updateCourse(id, dto);

        return ResponseEntity.ok(new ApiResponse<>(true, "Course Updated Successfully", course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseResponseDTO>> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);

        return ResponseEntity.ok(new ApiResponse<>(true, "Course Deleted Successfully", null));
    }

}
