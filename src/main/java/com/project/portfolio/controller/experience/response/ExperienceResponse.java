package com.project.portfolio.controller.experience.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExperienceResponse {
    int id;
    String departmentTitle;
    String workplace;
    String detail;
    LocalDate startDate;
    LocalDate endDate;
}
