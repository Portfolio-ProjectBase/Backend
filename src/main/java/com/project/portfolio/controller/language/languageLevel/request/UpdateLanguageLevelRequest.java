package com.project.portfolio.controller.language.languageLevel.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateLanguageLevelRequest {

    @NotNull
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private int level;
}
