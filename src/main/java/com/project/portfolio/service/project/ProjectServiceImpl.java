package com.project.portfolio.service.project;

import com.project.portfolio.controller.project.request.CreateProjectRequest;
import com.project.portfolio.controller.project.request.UpdateProjectRequest;
import com.project.portfolio.controller.project.response.ProjectResponse;
import com.project.portfolio.repository.project.Project;
import com.project.portfolio.repository.project.ProjectRepository;
import com.project.portfolio.repository.skill.Skill;
import com.project.portfolio.repository.skill.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;
    private final SkillRepository skillRepository;

    @Override
    public void create(CreateProjectRequest createProjectRequest) {
        Project project = toEntity(createProjectRequest);
        projectRepository.save(project);
    }

    @Override
    public void update(UpdateProjectRequest updateProjectRequest) {
        Project project = toEntity(updateProjectRequest);
        projectRepository.save(project);
    }

    @Override
    public List<ProjectResponse> getAll() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream().map(Project::toResponse).toList();
    }

    @Override
    public ProjectResponse getById(int id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Project not found with id: " + id));
        return project.toResponse();
    }

    @Override
    public void delete(int id) {
        projectRepository.deleteById(id);
    }

    public Project toEntity(CreateProjectRequest createProjectRequest) {
        List<Skill> skills = createProjectRequest.getSkillIds() != null ? createProjectRequest.getSkillIds().stream()
                .map(skillId -> skillRepository.findById(skillId)
                        .orElseThrow(() -> new IllegalArgumentException("Skill not found with id: " + skillId)))
                .collect(Collectors.toList()) : null;

        return Project.builder()
                .title(createProjectRequest.getTitle())
                .detail(createProjectRequest.getDetail())
                .projectDate(createProjectRequest.getProjectDate())
                .liveSiteLink(createProjectRequest.getLiveSiteLink())
                .githubLink(createProjectRequest.getGithubLink())
                .skills(skills)
                .build();
    }

    public Project toEntity(UpdateProjectRequest updateProjectRequest) {
        List<Skill> skills = updateProjectRequest.getSkillIds() != null ? updateProjectRequest.getSkillIds().stream()
                .map(skillId -> skillRepository.findById(skillId)
                        .orElseThrow(() -> new IllegalArgumentException("Skill not found with id: " + skillId)))
                .collect(Collectors.toList()) : null;

        return Project.builder()
                .id(updateProjectRequest.getId())
                .title(updateProjectRequest.getTitle())
                .detail(updateProjectRequest.getDetail())
                .projectDate(updateProjectRequest.getProjectDate())
                .liveSiteLink(updateProjectRequest.getLiveSiteLink())
                .githubLink(updateProjectRequest.getGithubLink())
                .skills(skills)
                .build();
    }
}
