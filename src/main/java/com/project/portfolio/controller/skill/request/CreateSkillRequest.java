package com.project.portfolio.controller.skill.request;

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
public class CreateSkillRequest {

    @NotBlank
    private String name;

    @NotBlank
    private int projectId;

    @NotBlank
    private int postId;

}
