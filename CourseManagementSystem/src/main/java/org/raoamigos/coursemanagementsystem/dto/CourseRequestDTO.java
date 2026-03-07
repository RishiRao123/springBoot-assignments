package org.raoamigos.coursemanagementsystem.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseRequestDTO {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;

    @NotBlank(message = "Instructor name is required")
    private String instructor;

    @Min(value = 1, message = "Duration must be at least 1 hour")
    private int duration;

    @PositiveOrZero(message = "Price cannot be negative")
    private Double price;
}