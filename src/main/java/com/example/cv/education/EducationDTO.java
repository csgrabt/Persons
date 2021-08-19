package com.example.cv.education;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDTO {
    private Long id;
    private String major;
    private Integer yearOfFinished;
}
