package com.project.portfolio.controller.postContent.request;

import jakarta.validation.constraints.NotNull;

public class UpdatePostContentRequest {
    @NotNull
    private int id;
    private String contentType; // TEXT, CODE, IMAGE
    private String content;     // Metin veya kod içeriği.
    private  byte[] image;
    private Integer orderIndex; // Sıra bilgisi.
}
