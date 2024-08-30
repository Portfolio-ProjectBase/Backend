package com.project.portfolio.controller.education.request;

import com.project.portfolio.core.utilities.NoFutureDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateEducationRequest {
    @NotNull
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    @NoFutureDate
    private Date startDate;
    @NotBlank
    private Date finishDate;
    @NotBlank
    private String major;
}
