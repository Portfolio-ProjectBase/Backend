package com.project.portfolio.controller.post;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.portfolio.controller.BaseController;
import com.project.portfolio.controller.post.request.CreatePostRequest;
import com.project.portfolio.controller.post.request.UpdatePostRequest;
import com.project.portfolio.controller.post.response.PostResponse;
import com.project.portfolio.controller.postContent.request.CreatePostContentRequest;
import com.project.portfolio.controller.postContent.request.UpdatePostContentRequest;
import com.project.portfolio.service.post.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
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

    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update an existing post with content", description = "Update a blog post with dynamic elements and multiple image files.")
    public ResponseEntity<Void> updatePost(
            @RequestPart(value = "images", required = false) List<MultipartFile> imageFiles, // Güncelleme sırasında yüklenen dosyalar
            @Parameter(
                    required = true,
                    schema = @Schema(implementation = UpdatePostRequest.class)
            )
            @RequestPart("body") String requestBodyAsJson) {

        try {
            // JSON String'i DTO'ya dönüştür
            UpdatePostRequest updatePostRequest = objectMapper.readValue(requestBodyAsJson, UpdatePostRequest.class);
            System.out.println("UpdatePostRequest: " + updatePostRequest);
            for (UpdatePostContentRequest contentRequest : updatePostRequest.getElements()) {
                System.out.println("Content ID: " + contentRequest.getId());
                System.out.println("Content Type: " + contentRequest.getContentType());
                System.out.println("Content: " + contentRequest.getContent());
            }

            // Dinamik element listesini request içinden al
            List<UpdatePostContentRequest> contentRequests = updatePostRequest.getElements();
            System.out.println("ContentRequests: " + contentRequests);

            // Eğer IMAGE içeriği varsa ve `isGetNewPicture` true ise, en az bir dosya olmalı
            long requiredImagesCount = contentRequests.stream()
                    .filter(element -> "IMAGE".equalsIgnoreCase(element.getContentType()) && Boolean.TRUE.equals(element.getIsGetNewPicture()))
                    .count();
            System.out.println("RequiredImagesCount: " + requiredImagesCount);

            if (requiredImagesCount > 0 && (imageFiles == null || imageFiles.size() < requiredImagesCount)) {
                throw new IllegalArgumentException("Image files are required when isGetNewPicture is true for IMAGE elements.");
            }

            // Servisi çağır
            postService.update(updatePostRequest, contentRequests, imageFiles);
            return ResponseEntity.noContent().build(); // Başarılı işlem durumunda boş içerik dön
        } catch (Exception e) {
            e.printStackTrace(); // Hata detaylarını konsola yazdır
            throw new RuntimeException("Error while updating post", e);
        }

    }



    @GetMapping
    @Operation(summary = "Get all posts with pagination and sorting")
    public ResponseEntity<Page<PostResponse>> getAllPosts(
            @RequestParam(value = "search", required = false) String search,
            @RequestParam(value = "sort", defaultValue = "desc") String sortDirection, // Sıralama yönü
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {

        // Sıralama yönünü belirle
        Sort.Direction direction = sortDirection.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;

        // Pageable nesnesini oluştur
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, "createdDate"));


        // Servisi çağır
        Page<PostResponse> posts = postService.getAllPosts(search, pageable);
        return ResponseEntity.ok(posts);
    }


}
