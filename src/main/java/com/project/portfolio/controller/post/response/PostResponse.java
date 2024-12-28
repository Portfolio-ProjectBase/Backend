package com.project.portfolio.controller.post.response;

import com.project.portfolio.controller.ImageBaseResponse;
import com.project.portfolio.controller.postContent.response.PostContentResponse;
import com.project.portfolio.controller.skill.response.SkillResponse;
import com.project.portfolio.core.Base;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class PostResponse  extends Base {
    private String title;
    private String detail;
    private boolean isActive;
    private List<PostContentResponse> contents;
}
