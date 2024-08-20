package com.project.portfolio.service.post;


import com.project.portfolio.controller.post.request.CreatePostRequest;
import com.project.portfolio.controller.post.request.UpdatePostRequest;
import com.project.portfolio.controller.post.response.PostResponse;
import com.project.portfolio.repository.post.Post;
import com.project.portfolio.repository.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

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
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Post not found with id: " + id));
        return post.toResponse();
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
                .build();
    }

  public Post toEntity( UpdatePostRequest request){
        return Post.builder()
                .id(request.getId())
                .title(request.getTitle())
                .detail(request.getDetail())
                .isActive(request.isActive())
                .build();
  }
}
