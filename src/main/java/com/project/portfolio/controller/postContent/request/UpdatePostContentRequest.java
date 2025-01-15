package com.project.portfolio.controller.postContent.request;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePostContentRequest {
    @Min(-100)
    private Integer  id;
    private String contentType; // TEXT, CODE, IMAGE
    private String content;     // Metin veya kod içeriği.
    private Boolean isGetNewPicture;
}
