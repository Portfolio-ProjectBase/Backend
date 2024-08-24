package com.project.portfolio.controller.socialMedia.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UpdateSocialMediaRequest {
    @NotNull
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String link;
    private byte[] image;
}
