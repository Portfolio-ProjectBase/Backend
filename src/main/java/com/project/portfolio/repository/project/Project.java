package com.project.portfolio.repository.project;

import com.project.portfolio.core.Base;
import com.project.portfolio.repository.skill.Skill;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Projects")
public class Project extends Base {
    @Column(name = "title")
    private String title;
    @Column(name = "detail")
    private String detail;
    @Column(name = "project_date")
    private LocalDate projectDate;

    @Column(name = "live_site_link")
    private String liveSiteLink;
    @Column(name = "github_link")
    private String githubLink;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;
}
