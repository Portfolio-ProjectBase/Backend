package com.project.portfolio.controller.about.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAboutRequest {
    @NotBlank
    private String detail;
}
