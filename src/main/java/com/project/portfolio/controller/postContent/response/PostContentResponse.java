package com.project.portfolio.controller.postContent.response;

import com.project.portfolio.controller.ImageBaseResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class PostContentResponse extends ImageBaseResponse {

    private String type;
    private String content;
    private Integer orderIndex;
}
