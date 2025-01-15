package com.project.portfolio.service.post;

import com.project.portfolio.controller.post.request.CreatePostRequest;
import com.project.portfolio.controller.post.request.UpdatePostRequest;
import com.project.portfolio.controller.postContent.request.CreatePostContentRequest;
import com.project.portfolio.controller.post.response.PostResponse;
import com.project.portfolio.controller.postContent.request.UpdatePostContentRequest;
import com.project.portfolio.controller.postContent.response.PostContentResponse;
import com.project.portfolio.repository.post.Post;
import com.project.portfolio.repository.post.PostRepository;
import com.project.portfolio.repository.postContent.PostContent;
import com.project.portfolio.repository.postContent.PostContentRepository;
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
    private final PostContentRepository postContentRepository;

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
                    .contentType(elementRequest.getContentType())
                    .content(elementRequest.getContent())
                    .isGetNewPicture(true)
                    .post(blog)
                    .orderIndex(orderIndex++);

            if ("IMAGE".equals(elementRequest.getContentType()) && imageFiles != null && !imageFiles.isEmpty()) {
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

    @Override
    public void update(UpdatePostRequest updatePostRequest,
                       List<UpdatePostContentRequest> elementRequests,
                       List<MultipartFile> imageFiles) {

        // Mevcut Post'u bul
        Post existingPost = postRepository.findById(updatePostRequest.getId())
                .orElseThrow(() -> new EntityNotFoundException("Post not found with ID: " + updatePostRequest.getId()));

        // Ana başlık güncellemesi
        existingPost.setTitle(updatePostRequest.getTitle());
        existingPost.setActive(updatePostRequest.isActive());

        // İçerikleri güncelleme
        List<PostContent> updatedContents = new ArrayList<>();
        int orderIndex = 1;

        for (UpdatePostContentRequest elementRequest : elementRequests) {
            PostContent content;
            if (elementRequest.getId() == null || elementRequest.getId() < 0) {
                content = new PostContent();
                content.setPost(existingPost); // Yeni içeriği mevcut Post'a bağla
                content.setContentType(elementRequest.getContentType());
                content.setContent(elementRequest.getContent());
                content.setIsGetNewPicture(elementRequest.getIsGetNewPicture());
                content.setOrderIndex(orderIndex++); // Sıra numarası
                if ("IMAGE".equals(elementRequest.getContentType())) {
                    if (Boolean.TRUE.equals(elementRequest.getIsGetNewPicture()) && imageFiles != null && !imageFiles.isEmpty()) {
                        // Yeni resim varsa, eşleşen dosyayı işle
                        MultipartFile matchingFile = findMatchingImageFile(imageFiles, elementRequest.getContent());
                        if (matchingFile != null) {
                            byte[] imageData = processImageFile(matchingFile);
                            content.setImage(imageData);
                        }
                    } else {
                        // Yeni resim gönderilmediyse, image alanını boş bırak
                        content.setImage(null);
                    }
                }
            } else {
                content = postContentRepository.findById(elementRequest.getId())
                        .orElseThrow(() -> new EntityNotFoundException("PostContent not found with ID: " + elementRequest.getId()));

                content.setContentType(elementRequest.getContentType());
                content.setContent(elementRequest.getContent());
                content.setOrderIndex(orderIndex++);
            }

            if (elementRequest.getContentType() == null || elementRequest.getContentType().isEmpty()) {
                throw new IllegalArgumentException("ContentType cannot be null or empty");
            }

            if ("IMAGE".equals(elementRequest.getContentType())) {
                if (Boolean.TRUE.equals(elementRequest.getIsGetNewPicture()) && imageFiles != null && !imageFiles.isEmpty()) {
                    // Yeni resimler eklenmişse
                    MultipartFile matchingFile = findMatchingImageFile(imageFiles, elementRequest.getContent());
                    if (matchingFile != null) {
                        byte[] imageData = processImageFile(matchingFile);
                        content.setImage(imageData);
                    }
                } else if (Boolean.FALSE.equals(elementRequest.getIsGetNewPicture())) {
                    // Yeni resim eklenmemişse, eski resmi koru
                    content.setImage(content.getImage());
                }
            }

            updatedContents.add(content);
        }

        // İçerikleri kaydet
        postContentRepository.saveAll(updatedContents);

        // Ana Post'u kaydet
        postRepository.save(existingPost);
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
                .elements(blog.getElements().stream()
                        .map(this::buildBlogElementResponse)
                        .toList())
                .createdDate(blog.getCreatedDate())
                .build();
    }

    private PostContentResponse buildBlogElementResponse(PostContent element) {
        return PostContentResponse.builder()
                .id(element.getId())
                .contentType(element.getContentType())
                .content(element.getContent())
                .imageBase64(element.getIsGetNewPicture() ? element.getImageBase64() : null)
                .orderIndex(element.getOrderIndex())
                .isGetNewPicture(element.getIsGetNewPicture())
                .build();
    }
}
