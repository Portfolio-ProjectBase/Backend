package com.project.portfolio.repository.project;

import com.project.portfolio.controller.project.response.ProjectResponse;
import com.project.portfolio.core.Base;
import com.project.portfolio.repository.skill.Skill;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    @ManyToMany
    @JoinTable(
            name = "project_skill",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;

    public ProjectResponse toResponse(){
        return ProjectResponse.builder()
                .id(getId())
                .title(getTitle())
                .detail(getDetail())
                .projectDate(getProjectDate())
                .liveSiteLink(getLiveSiteLink())
                .githubLink(getGithubLink())
                .skills(skills.stream().map(Skill::toResponse).collect(Collectors.toList()))
                .build();
    }

    public static Project fromResponse(ProjectResponse response){
        return Project.builder()
                .id(response.getId())
                .title(response.getTitle())
                .detail(response.getDetail())
                .projectDate(response.getProjectDate())
                .liveSiteLink(response.getLiveSiteLink())
                .githubLink(response.getGithubLink())
                .skills(response.getSkills().stream()
                        .map(skillResponse -> Skill.builder()
                                .id(skillResponse.getId())
                                .name(skillResponse.getName())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}

