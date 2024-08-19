package com.project.portfolio.controller.experience.response;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ExperienceResponse {
    int id;
    String departmentTitle;
    String workplace;
    String detail;
    String position;
    LocalDate startDate;
    LocalDate finishDate;
}
