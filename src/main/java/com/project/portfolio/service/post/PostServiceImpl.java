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
    private final PostRules rules;

    @Override
    public void create(CreatePostRequest createPostRequest) {
        rules.check(rules.fix(createPostRequest));
        Post post = toEntity(createPostRequest);
        postRepository.save(post);
    }

    @Override
    public void update(UpdatePostRequest updatePostRequest) {
        rules.check(rules.fix(updatePostRequest));
        Post post = toEntity(updatePostRequest);
        postRepository.save(post);
    }

    @Override
    public List<PostResponse> getAll() {
        List<Post> posts = postRepository.findAll();
        rules.checkDataList(posts);
        return posts.stream().map(Post::toResponse).toList();
    }

    @Override
    public PostResponse getById(int id) {
        rules.checkData(id);
        Post post = postRepository.findById(id).orElseThrow();
        return post.toResponse();
    }

    @Override
    public void delete(int id) {
        rules.checkData(id);
        postRepository.deleteById(id);
    }

    public Post toEntity(CreatePostRequest request) {

        return Post.builder()
                .title(request.getTitle())
                .detail(request.getDetail())
                .isActive(request.isActive())
                .image(request.getImage())
                .build();
    }

    public Post toEntity(UpdatePostRequest request) {

        return Post.builder()
                .id(request.getId())
                .title(request.getTitle())
                .detail(request.getDetail())
                .isActive(request.isActive())
                .image(request.getImage())
                .build();
    }
}
