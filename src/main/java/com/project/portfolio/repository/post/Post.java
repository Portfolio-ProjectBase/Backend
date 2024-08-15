package com.project.portfolio.repository.post;

import com.project.portfolio.controller.post.response.PostResponse;
import com.project.portfolio.core.Base;
import com.project.portfolio.repository.skill.Skill;
import com.project.portfolio.repository.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

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
    @Column(name = "detail")
    private String detail;

    @Column(name = "is_active")
    private boolean isActive;

    @OneToMany(mappedBy = "post")
    private List<Skill> skills;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public PostResponse toResponse(){
        return PostResponse.builder()
                .id(getId())
                .title(getTitle())
                .detail(getDetail())
                //.isActive(getIsActive())
                .isDeleted(getIsDeleted())
                .build();
    }

    public static Post fromResponse(PostResponse response){
        return Post.builder()
                .id(response.getId())
                .title(response.getTitle())
                .detail(response.getDetail())
                .isActive(response.isActive())
                .isDeleted(response.isDeleted())
                .build();


    }
}
