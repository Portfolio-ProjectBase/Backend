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
    int id;
    String title;
    String detail;
    boolean isActive;
    boolean isDeleted;
    private List<SkillResponse> skills;
}
