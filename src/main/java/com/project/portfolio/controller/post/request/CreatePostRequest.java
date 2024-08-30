package com.project.portfolio.controller.post.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostRequest {
    private String title;
    private String detail;
    private boolean isActive;
    private byte[] image;
    private List<Integer> skillIds; // Skill id'leri üzerinden ilişki kurulacak

}
