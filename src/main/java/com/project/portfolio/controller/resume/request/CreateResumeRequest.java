package com.project.portfolio.controller.resume.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateResumeRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String fileUrl;

    private String fileType;

}
