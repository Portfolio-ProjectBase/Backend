package com.project.portfolio.controller.hobby.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateHobbyRequest {

    @NotBlank
    private int id;

    @NotBlank
    private String name;
}
