package com.project.portfolio.repository.skill;

import com.project.portfolio.controller.skill.response.SkillResponse;
import com.project.portfolio.core.ImageBase;
import com.project.portfolio.core.utilities.ImageUtils;
import com.project.portfolio.repository.post.Post;
import com.project.portfolio.repository.project.Project;
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
public class Skill extends ImageBase {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "skills")
    private List<Project> projects;

    public SkillResponse toResponse() {
        return SkillResponse.builder()
                .id(getId())
                .name(getName())
                .imageBase64(getImageBase64()) // getImageBase64 metodunu kullanarak base64 string elde et
                .build();
    }
}
