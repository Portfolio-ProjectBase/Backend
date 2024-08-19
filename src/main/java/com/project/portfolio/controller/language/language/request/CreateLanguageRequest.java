package com.project.portfolio.controller.language.language.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateLanguageRequest {

    @NotBlank
    private String name;

    @NotBlank
    private int levelId;
}
