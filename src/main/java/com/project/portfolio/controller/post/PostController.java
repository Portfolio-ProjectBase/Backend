package com.project.portfolio.controller.post;

import com.project.portfolio.controller.BaseController;
import com.project.portfolio.controller.post.request.CreatePostRequest;
import com.project.portfolio.controller.post.request.UpdatePostRequest;
import com.project.portfolio.controller.post.response.PostResponse;
import com.project.portfolio.controller.skill.request.UpdateSkillRequest;
import com.project.portfolio.service.post.PostService;
import io.swagger.models.auth.In;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
@RequiredArgsConstructor
public class PostController extends BaseController {

    private final PostService postService;

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Void> create(
                                       @Valid
                                       @RequestParam String title,
                                       @RequestParam String detail,
                                       @RequestParam boolean isActive,
                                       @RequestPart(value = "image", required = false) MultipartFile image){
        CreatePostRequest request = new CreatePostRequest();
        request.setTitle(title);
        request.setDetail(detail);
        request.setActive(isActive);
        if (image != null) {
            try {
                request.setImage(image.getBytes());
            } catch (IOException e) {
                return answer(HttpStatus.BAD_REQUEST); // Resim yükleme hatası durumunda
            }
        }
        postService.create(request);
        return answer(HttpStatus.NO_CONTENT);
    }

    @PutMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Void> update(@Valid
                                       @RequestParam("id") int id,
                                       @RequestParam String title,
                                       @RequestParam String detail,
                                       @RequestParam boolean isActive,
                                       @RequestPart(value = "image", required = false) MultipartFile image){

        UpdatePostRequest request = UpdatePostRequest.builder()
                .id(id)
                .title(title)
                .detail(detail)
                .isActive(isActive)
                .build();
        if (image != null) {
            try {
                request.setImage(image.getBytes());
            } catch (IOException e) {
                return answer(HttpStatus.BAD_REQUEST); // Resim yükleme hatası durumunda
            }
        }
        postService.update(request);
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
