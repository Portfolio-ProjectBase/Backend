package com.project.portfolio.controller.project.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProjectRequest {
    @NotNull
    private int id;
    @NotBlank
    private String title;
    @NotBlank
    private String detail;
    @NotNull
    private LocalDate projectDate;
    @NotBlank
    private String liveSiteLink;
    @NotBlank
    private String githubLink;
}
