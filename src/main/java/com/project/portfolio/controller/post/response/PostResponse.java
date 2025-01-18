package com.project.portfolio.controller.post.response;

import com.project.portfolio.controller.ImageBaseResponse;
import com.project.portfolio.controller.postContent.response.PostContentResponse;
import com.project.portfolio.controller.skill.response.SkillResponse;
import com.project.portfolio.core.Base;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class PostResponse {
    private int id;
    private String title;
    private String detail;
    private Boolean isActive;
    private List<PostContentResponse> elements;
    private LocalDateTime createdDate;
}
