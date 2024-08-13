package com.project.portfolio.controller.post.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostResponse {
    int id;
    String title;
    String detail;
    int skillId;
    boolean isActive;
    boolean isDeleted;
}
