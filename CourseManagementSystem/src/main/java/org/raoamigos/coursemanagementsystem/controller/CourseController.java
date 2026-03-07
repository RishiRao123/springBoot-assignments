package org.raoamigos.coursemanagementsystem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.raoamigos.coursemanagementsystem.dto.CourseRequestDTO;
import org.raoamigos.coursemanagementsystem.dto.CourseResponseDTO;
import org.raoamigos.coursemanagementsystem.payload.ApiResponse;
import org.raoamigos.coursemanagementsystem.service.CourseService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<ApiResponse<CourseResponseDTO>> createCourse(@Valid @RequestBody CourseRequestDTO dto) {
        CourseResponseDTO createdCourse = courseService.createCourse(dto);
        ApiResponse<CourseResponseDTO> apiResponse = new ApiResponse<>(true, "Course Created Succesfully", createdCourse);

        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseResponseDTO>> getCourseById(@PathVariable Long id) {
        CourseResponseDTO course = courseService.getCourseById(id);
        ApiResponse<CourseResponseDTO> apiResponse = new ApiResponse<>(true, "Course Fetched Successfully", course);

        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<Page<CourseResponseDTO>>> getAllCourses(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        Page<CourseResponseDTO> courses = courseService.getAllCourses(page, size, sortBy);

        ApiResponse<Page<CourseResponseDTO>> response = new ApiResponse<>(true,
                        "Courses fetched successfully",
                        courses);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseResponseDTO>> updateCourse(@PathVariable Long id, @Valid @RequestBody CourseRequestDTO dto) {
        CourseResponseDTO updatedCourse = courseService.updateCourse(id, dto);
        ApiResponse<CourseResponseDTO> response = new ApiResponse<>(true,  "Course Updated Succesfully", updatedCourse);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<ApiResponse<?>> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        ApiResponse<?> response =
                new ApiResponse<>(true,
                        "Course deleted successfully",
                        null);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
