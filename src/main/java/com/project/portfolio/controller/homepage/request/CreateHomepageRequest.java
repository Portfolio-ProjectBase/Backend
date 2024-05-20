package com.project.portfolio.controller.homepage.request;

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
public class CreateHomepageRequest {
    @NotBlank
    private String detail;

    @NotNull
    private int socialMediaId;
}
