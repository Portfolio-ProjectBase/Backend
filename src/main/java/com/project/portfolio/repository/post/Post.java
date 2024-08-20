package com.project.portfolio.repository.post;

import com.project.portfolio.controller.post.response.PostResponse;
import com.project.portfolio.core.Base;
import com.project.portfolio.repository.skill.Skill;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

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
    @Column(name = "detail")
    private String detail;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToMany(mappedBy = "posts")
    private List<Skill> skills;



    public PostResponse toResponse(){
        return PostResponse.builder()
                .id(getId())
                .title(getTitle())
                .detail(getDetail())
                .isActive(isActive())
                .isDeleted(getIsDeleted())
                .skills(skills.stream().map(Skill::toResponse).collect(Collectors.toList())) // Convert Skill entities to SkillResponse
                .build();
    }

    public static Post fromResponse(PostResponse response){
        return Post.builder()
                .id(response.getId())
                .title(response.getTitle())
                .detail(response.getDetail())
                .isActive(response.isActive())
                .isDeleted(response.isDeleted())
                .skills(response.getSkills().stream()
                   .map(skillResponse -> Skill.builder()
                          .id(skillResponse.getId())
                            .name(skillResponse.getName())
                           .build())
                   .collect(Collectors.toList()))
                .build();


    }
}
