package com.project.portfolio.controller.post.response;

import com.project.portfolio.controller.ImageBaseResponse;
import com.project.portfolio.controller.skill.response.SkillResponse;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class PostResponse extends ImageBaseResponse {
    private String title;
    private String detail;
    private boolean isActive;
    private List<SkillResponse> skills; // SkillResponse objeleriyle ilişkilendirilmiş Skill'ler
}
