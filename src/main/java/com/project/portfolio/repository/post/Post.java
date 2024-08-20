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

    @ManyToMany
    @JoinTable(
            name = "post_skill",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;

    public PostResponse toResponse(){
        return PostResponse.builder()
                .id(getId())
                .title(getTitle())
                .detail(getDetail())
                .isActive(isActive())
                .isDeleted(getIsDeleted())
                .skills(skills.stream().map(Skill::toResponse).collect(Collectors.toList()))
                .build();
    }

}

