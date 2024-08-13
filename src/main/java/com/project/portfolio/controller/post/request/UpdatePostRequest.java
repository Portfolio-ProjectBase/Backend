package com.project.portfolio.controller.post.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePostRequest {
    @NotNull
    private int id;

    @NotBlank
    private String title;

    @NotBlank
    private String detail;

    @NotNull
    private int skillId;

    boolean isActive;
    boolean isDeleted;
}
