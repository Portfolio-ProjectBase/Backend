package com.project.portfolio.controller.homepage.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateHomepageRequest {
    @NotNull
    int id;

    @NotBlank
    private String detail;

    @NotNull
    private int socialMediaId;
}
