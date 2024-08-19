package com.project.portfolio.repository.skill;

import com.project.portfolio.controller.skill.response.SkillResponse;
import com.project.portfolio.core.Base;
import com.project.portfolio.repository.post.Post;
import com.project.portfolio.repository.project.Project;
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
@Entity
@Table(name = "Skills")
@SuperBuilder
public class Skill extends Base {

    @Column(name = "name")
    private String name;

    @ManyToMany
    private List<Post> posts;
    @ManyToMany
    private List<Project> projects;

    public SkillResponse toResponse(){
        return SkillResponse.builder()
                .id(getId())
                .name(getName())
                .build();
    }

    public Skill fromResponse(SkillResponse skillResponse){
        return Skill.builder()
                .id(skillResponse.getId())
                .name(skillResponse.getName())
                .build();
    }

}
