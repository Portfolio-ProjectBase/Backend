package com.project.portfolio.service.post;

import com.project.portfolio.controller.post.request.CreatePostRequest;
import com.project.portfolio.controller.post.request.UpdatePostRequest;
import com.project.portfolio.controller.post.response.PostResponse;
import com.project.portfolio.controller.postContent.request.CreatePostContentRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PostService {

    PostResponse create(CreatePostRequest createPostRequest,
                        List<CreatePostContentRequest> elementRequests,
                        List<MultipartFile> imageFiles);

    Page<PostResponse> getAllPosts(String search, Pageable pageable) ;


}
