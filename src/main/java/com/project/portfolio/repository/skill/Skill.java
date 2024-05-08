package com.project.portfolio.repository.skill;

import com.project.portfolio.core.Base;
import com.project.portfolio.repository.blog.Blog;
import com.project.portfolio.repository.project.Project;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Skills")
public class Skill extends Base {
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "skill")
    private List<Project> projects;

    @OneToMany(mappedBy = "skill")
    private List<Blog> blogs;
}
