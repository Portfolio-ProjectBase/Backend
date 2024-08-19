package com.project.portfolio.controller.post.response;

import lombok.*;

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
}
