package com.project.portfolio.controller.post.request;

import com.project.portfolio.controller.postContent.request.CreatePostContentRequest;

import java.util.List;

public class CreateBlogRequest {
    private CreatePostRequest blog;
    private List<CreatePostContentRequest> elements;

    // Getter ve Setter
    public CreatePostRequest getBlog() {
        return blog;
    }

    public void setBlog(CreatePostRequest blog) {
        this.blog = blog;
    }

    public List<CreatePostContentRequest> getElements() {
        return elements;
    }

    public void setElements(List<CreatePostContentRequest> elements) {
        this.elements = elements;
    }
}
