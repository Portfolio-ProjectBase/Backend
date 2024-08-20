package com.project.portfolio.controller.post;

import com.project.portfolio.controller.BaseController;
import com.project.portfolio.controller.post.request.CreatePostRequest;
import com.project.portfolio.controller.post.request.UpdatePostRequest;
import com.project.portfolio.controller.post.response.PostResponse;
import com.project.portfolio.service.post.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
@RequiredArgsConstructor
public class PostController extends BaseController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreatePostRequest createPostRequest){
        postService.create(createPostRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid UpdatePostRequest updatePostRequest){
        postService.update(updatePostRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getById(@PathVariable int id){
        PostResponse response = postService.getById(id);
        return answer(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAll(){
        List<PostResponse> responses = postService.getAll();
        return answer(responses, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        postService.delete(id);
        return answer(HttpStatus.NO_CONTENT);
    }

}
