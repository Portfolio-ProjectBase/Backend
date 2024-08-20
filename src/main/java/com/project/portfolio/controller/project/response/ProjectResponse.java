package com.project.portfolio.controller.project.response;

import com.project.portfolio.controller.skill.response.SkillResponse;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProjectResponse {
    private int id;
    private String title;
    private String detail;
    private LocalDate projectDate;
    private String liveSiteLink;
    private String githubLink;
    private List<SkillResponse> skills; // SkillResponse objeleriyle ilişkilendirilmiş Skill'ler
}
