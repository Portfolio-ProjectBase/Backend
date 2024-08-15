package com.project.portfolio.controller.experience.response;

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
    LocalDate startDate;
    LocalDate finishDate;
}
