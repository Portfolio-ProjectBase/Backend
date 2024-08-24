package com.project.portfolio.controller.socialMedia.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateSocialMediaRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String link;
    private byte[] image;
}
