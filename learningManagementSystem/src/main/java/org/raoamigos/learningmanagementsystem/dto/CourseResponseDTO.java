package org.raoamigos.learningmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CourseResponseDTO {

    private Long id;
    private String title;
    private String description;
    private double price;
    private int duration;
    private String instructorName;
}
