package com.project.portfolio.controller.about.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAboutRequest {
    @NotNull
    private int id;

    @NotBlank
    private String detail;
}
