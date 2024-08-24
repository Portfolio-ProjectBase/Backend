package com.project.portfolio.controller.post.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdatePostRequest {
    @NotNull
    private int id;

    @NotBlank
    private String title;

    @NotBlank
    private String detail;
    private byte[] image;

    boolean isActive;
    private List<Integer> skillIds;
}
