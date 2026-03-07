package org.raoamigos.learningmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EnrollmentResponseDTO {

    private Long enrollmentId;
    private String studentName;
    private String courseName;
    private LocalDate enrollmentDate;
}
