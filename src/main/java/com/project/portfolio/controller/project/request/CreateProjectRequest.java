package com.project.portfolio.controller.project.request;

import com.project.portfolio.core.utilities.NoFutureDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateProjectRequest {

    private String title;
    private String detail;
    @NoFutureDate
    private LocalDate projectDate;
    private String liveSiteLink;
    private String githubLink;
    private List<Integer> skillIds; // Skill id'leri üzerinden ilişki kurulacak
}
