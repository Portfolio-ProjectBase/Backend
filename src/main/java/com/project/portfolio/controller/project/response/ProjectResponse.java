package com.project.portfolio.controller.project.response;

import com.project.portfolio.controller.ImageBaseResponse;
import com.project.portfolio.controller.skill.response.SkillResponse;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ProjectResponse extends ImageBaseResponse {
    private int id;
    private String title;
    private String detail;
    private LocalDate projectDate;
    private String liveSiteLink;
    private String githubLink;

    private List<String> skillName; // SkillResponse objeleriyle ilişkilendirilmiş Skill'ler
}
