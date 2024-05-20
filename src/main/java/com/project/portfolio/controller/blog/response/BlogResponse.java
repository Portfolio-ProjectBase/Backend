package com.project.portfolio.controller.blog.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BlogResponse {
    int id;
    String title;
    String detail;
    int skillId;
    boolean isActive;
    boolean isDeleted;
}
