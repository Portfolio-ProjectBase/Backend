package com.project.portfolio.repository.post;

import com.project.portfolio.controller.post.response.PostResponse;
import com.project.portfolio.core.Base;
import com.project.portfolio.core.ImageBase;
import com.project.portfolio.repository.postContent.PostContent;
import com.project.portfolio.repository.skill.Skill;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Posts")
@Entity
@SuperBuilder
public class Post extends Base {
    @Column(name = "title")
    private String title;

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("orderIndex ASC")
    private List<PostContent>  elements = new ArrayList<>();



    public PostResponse toResponse(){
        return PostResponse.builder()
                .id(getId())
                .title(getTitle())
                .isActive(getIsActive())
                .build();
    }

}

