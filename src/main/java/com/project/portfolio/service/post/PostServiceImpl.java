package com.project.portfolio.service.post;

import com.project.portfolio.controller.post.request.CreatePostRequest;
import com.project.portfolio.controller.postContent.request.CreatePostContentRequest;
import com.project.portfolio.controller.post.response.PostResponse;
import com.project.portfolio.controller.postContent.response.PostContentResponse;
import com.project.portfolio.repository.post.Post;
import com.project.portfolio.repository.post.PostRepository;
import com.project.portfolio.repository.postContent.PostContent;
import com.project.portfolio.service.ImageRules;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostResponse create(CreatePostRequest blogRequest,
                               List<CreatePostContentRequest> elementRequests,
                               List<MultipartFile> imageFiles) {
        Post blog = Post.builder()
                .title(blogRequest.getTitle())
                .build();

        List<PostContent> elements = new ArrayList<>();
        int orderIndex = 1;

        for (CreatePostContentRequest elementRequest : elementRequests) {
            PostContent.PostContentBuilder builder = PostContent.builder()
                    .type(elementRequest.getType())
                    .content(elementRequest.getContent())
                    .post(blog)
                    .orderIndex(orderIndex++);

            if ("IMAGE".equals(elementRequest.getType()) && imageFiles != null && !imageFiles.isEmpty()) {
                MultipartFile matchingFile = findMatchingImageFile(imageFiles, elementRequest.getContent());
                if (matchingFile != null) {
                    byte[] imageData = processImageFile(matchingFile);
                    builder.image(imageData);
                }
            }

            elements.add(builder.build());
        }

        blog.setElements(elements);
        blog = postRepository.save(blog);

        return buildBlogResponse(blog);
    }

    @Override
    public Page<PostResponse> getAllPosts(String search, Pageable pageable) {

        if (search != null && !search.isEmpty()) {
            return postRepository.findAllByTitleContainingIgnoreCase(search, pageable)
                    .map(this::buildBlogResponse);
        } else {
            return postRepository.findAll(pageable).map(this::buildBlogResponse);
        }
    }


    private MultipartFile findMatchingImageFile(List<MultipartFile> imageFiles, String content) {
        return imageFiles.stream()
                .filter(file -> file.getOriginalFilename() != null && file.getOriginalFilename().equals(content))
                .findFirst()
                .orElse(null);
    }

    private byte[] processImageFile(MultipartFile file) {
        try {
            ImageRules.validateMimeType(file.getContentType()); // MIME tipi kontrolü
            return file.getBytes(); // Resim verisini byte array olarak dön
        } catch (IOException e) {
            throw new RuntimeException("Error processing image file", e);
        }
    }


    private PostResponse buildBlogResponse(Post blog) {
        return PostResponse.builder()
                .id(blog.getId())
                .title(blog.getTitle())
                .contents(blog.getElements().stream()
                        .map(this::buildBlogElementResponse)
                        .toList())
                .createdDate(blog.getCreatedDate())
                .build();
    }

    private PostContentResponse buildBlogElementResponse(PostContent element) {
        return PostContentResponse.builder()
                .id(element.getId())
                .type(element.getType())
                .content(element.getContent())
                .imageBase64(element.getImageBase64()) // Eğer resim varsa Base64 olarak dön
                .orderIndex(element.getOrderIndex())
                .build();
    }
}
