package com.project.portfolio.repository.project;

import com.project.portfolio.controller.project.response.ProjectResponse;
import com.project.portfolio.core.Base;
import com.project.portfolio.repository.skill.Skill;
import com.project.portfolio.repository.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Projects")
@SuperBuilder
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

    @OneToMany(mappedBy = "project")
    private List<Skill> skills;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ProjectResponse toResponse(){
        return ProjectResponse.builder()
                .id(getId())
                .title(getTitle())
                .detail(getDetail())
                .projectDate(getProjectDate())
                .liveSiteLink(getLiveSiteLink())
                .githubLink(getGithubLink())
                .build();
    }

    public static Project fromResponse(ProjectResponse projectResponse){
        return Project.builder()
                .id(projectResponse.getId())
                .title(projectResponse.getTitle())
                .detail(projectResponse.getDetail())
                .projectDate(projectResponse.getProjectDate())
                .liveSiteLink(projectResponse.getLiveSiteLink())
                .githubLink(projectResponse.getGithubLink())
                .build();

    }

}
