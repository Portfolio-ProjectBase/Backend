package com.project.portfolio.controller.skill.response;

import com.project.portfolio.controller.ImageBaseResponse;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class SkillResponse extends ImageBaseResponse {
    private String name;
}
