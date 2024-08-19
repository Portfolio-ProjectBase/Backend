package com.project.portfolio.service.post;


import com.project.portfolio.controller.post.request.CreatePostRequest;
import com.project.portfolio.controller.post.request.UpdatePostRequest;
import com.project.portfolio.controller.post.response.PostResponse;
import com.project.portfolio.repository.post.Post;
import com.project.portfolio.repository.post.PostRepository;
import com.project.portfolio.repository.user.User;
import com.project.portfolio.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    @Override
    public void create(CreatePostRequest createPostRequest) {
        postRepository.save(toEntity(createPostRequest));
    }

    @Override
    public void update(UpdatePostRequest updatePostRequest) {
         postRepository.save(toEntity(updatePostRequest));
    }

    @Override
    public List<PostResponse> getAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(Post::toResponse).toList();
    }

    @Override
    public PostResponse getById(int id) {
        return postRepository.findById(id).orElseThrow().toResponse();
    }

    @Override
    public void delete(int id) {
        postRepository.deleteById(id);
    }

    public Post toEntity(CreatePostRequest request){
        return Post.builder()
                .title(request.getTitle())
                .detail(request.getDetail())
                .isActive(request.isActive())
                .isDeleted(request.isDeleted())
                .build();
    }

  public Post toEntity( UpdatePostRequest request){
        return Post.builder()
                .id(request.getId())
                .title(request.getTitle())
                .detail(request.getDetail())
                .isActive(request.isActive())
                .isDeleted(request.isDeleted())
                .build();
  }
}
