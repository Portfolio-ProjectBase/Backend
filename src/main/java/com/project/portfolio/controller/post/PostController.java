package com.project.portfolio.controller.post;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.portfolio.controller.BaseController;
import com.project.portfolio.controller.post.request.CreatePostRequest;
import com.project.portfolio.controller.post.response.PostResponse;
import com.project.portfolio.controller.postContent.request.CreatePostContentRequest;
import com.project.portfolio.service.post.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")
@RequiredArgsConstructor
public class PostController extends BaseController {

    private final PostService postService;
    private final ObjectMapper objectMapper; // Jackson'ın ObjectMapper'ı

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create a new blog with content", description = "Create a blog with dynamic elements and multiple image files.")
    public ResponseEntity<PostResponse> createBlog(
            @RequestPart(value = "images", required = false) List<MultipartFile> imageFiles,// Birden fazla dosya
            @Parameter(
                    required = true,
                    schema = @Schema(implementation = CreatePostRequest.class)
            )
            @RequestPart("body") String requestBodyAsJson) {

        try {
            // JSON String'i DTO'ya dönüştür
            CreatePostRequest blogRequest = objectMapper.readValue(requestBodyAsJson, CreatePostRequest.class);

            // Dinamik element listesini blogRequest'in içinden al
            List<CreatePostContentRequest> elementRequests = blogRequest.getElements();

            // Servis çağrısı
            PostResponse blogResponse = postService.create(blogRequest, elementRequests, imageFiles);
            return ResponseEntity.ok(blogResponse);
        } catch (Exception e) {
            throw new RuntimeException("JSON parsing error", e);
        }
    }
}
