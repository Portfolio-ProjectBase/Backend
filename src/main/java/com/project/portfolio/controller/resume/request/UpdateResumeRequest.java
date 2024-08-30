package com.project.portfolio.controller.resume.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateResumeRequest {

    @NotNull
    private int id;

    @NotBlank
    private String name;

    private String fileType;

}
