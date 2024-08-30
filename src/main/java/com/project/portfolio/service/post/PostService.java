package com.project.portfolio.service.post;

import com.project.portfolio.controller.post.request.CreatePostRequest;
import com.project.portfolio.controller.post.request.UpdatePostRequest;
import com.project.portfolio.controller.post.response.PostResponse;

import java.util.List;

public interface PostService {

    void create(CreatePostRequest createPostRequest);
    void update(UpdatePostRequest updatePostRequest);
    List<PostResponse> getAll(int page, int size);

    PostResponse getById(int id);
    void delete(int id);


}
