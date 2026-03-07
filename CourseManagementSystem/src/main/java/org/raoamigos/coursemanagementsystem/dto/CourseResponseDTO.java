package org.raoamigos.coursemanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseResponseDTO {

    private Long id;
    private String title;
    private String description;
    private String instructor;
    private int duration;
    private double price;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
