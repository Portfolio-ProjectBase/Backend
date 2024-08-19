package com.project.portfolio.controller.experience.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateExperienceRequest {
    @NotNull
    private int id;
    @NotBlank
    private String departmentTitle;
    @NotBlank
    private String workplace;
    @NotBlank
    private String detail;
    @NotBlank
    private String position;
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate finishDate;
}
