package com.project.portfolio.controller.skill.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UpdateSkillRequest {
    @NotNull
    private int id;

    private String name;

}
