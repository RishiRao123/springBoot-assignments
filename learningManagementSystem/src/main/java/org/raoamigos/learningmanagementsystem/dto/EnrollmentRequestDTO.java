package org.raoamigos.learningmanagementsystem.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EnrollmentRequestDTO {

    @NotNull(message = "Student Id cannot be  null")
    private Long studentId;

    @NotNull(message = "Course Id cannot be  null")
    private Long courseId;
}
