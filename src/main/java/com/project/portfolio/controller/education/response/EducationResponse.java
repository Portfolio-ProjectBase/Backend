package com.project.portfolio.controller.education.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EducationResponse {
    private int id;
    private String name;
    private LocalDate startDate;
    private LocalDate finishDate;
    private String major;
}
