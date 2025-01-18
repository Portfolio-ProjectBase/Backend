package com.project.portfolio.controller.post.request;

import com.project.portfolio.controller.postContent.request.CreatePostContentRequest;
import com.project.portfolio.controller.postContent.response.PostContentResponse;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreatePostRequest {
    private String title;
    private Boolean isActive;
    private List<CreatePostContentRequest> elements;
}
