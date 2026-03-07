package org.raoamigos.learningmanagementsystem.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseRequestDTO {

    @NotBlank(message = "Title cannot be empty")
    private String title;

    @Min(value = 1, message = "Duration should be greater than 1")
    private int duration;

    @PositiveOrZero(message = "Price cannot be negative")
    private double price;

    @NotNull
    private Long instructorId;
}
