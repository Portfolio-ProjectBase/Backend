package com.project.portfolio.repository.postContent;

import com.project.portfolio.controller.postContent.response.PostContentResponse;
import com.project.portfolio.core.ImageBase;
import com.project.portfolio.repository.post.Post;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "PostContents")
@Entity
@SuperBuilder
public class PostContent extends ImageBase {
    @Column(name = "type", nullable = false)
    private String type; // TEXT, IMAGE, CODE.

    @Column(name = "content", columnDefinition = "TEXT")
    private String content; // Metin veya kod içerikleri.

    @Column(name = "order_index", nullable = false)
    private int orderIndex;

    @Column(name = "isGetNewPicture")
    private Boolean isGetNewPicture;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;



}
