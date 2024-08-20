package com.project.portfolio.controller.post.response;

import com.project.portfolio.controller.skill.response.SkillResponse;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PostResponse {
    private int id;
    private String title;
    private String detail;
    private boolean isActive;
    private boolean isDeleted;
    private List<SkillResponse> skills; // SkillResponse objeleriyle ilişkilendirilmiş Skill'ler
}
