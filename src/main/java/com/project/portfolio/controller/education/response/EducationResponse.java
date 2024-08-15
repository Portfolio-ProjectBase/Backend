package com.project.portfolio.controller.education.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EducationResponse {
    private int id;
    private String name;
    private Date startDate;
    private Date finishDate;
    private String major;
}
