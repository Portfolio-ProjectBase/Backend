package com.project.portfolio.controller.post.request;

import com.project.portfolio.controller.postContent.response.PostContentResponse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdatePostRequest {
    @NotNull
    private int id;

    @NotBlank
    private String title;

    boolean isActive;
}
