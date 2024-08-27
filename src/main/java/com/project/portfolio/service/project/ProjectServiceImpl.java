package com.project.portfolio.service.project;

import com.project.portfolio.controller.project.request.CreateProjectRequest;
import com.project.portfolio.controller.project.request.UpdateProjectRequest;
import com.project.portfolio.controller.project.response.ProjectResponse;
import com.project.portfolio.core.exception.DataNotFoundException;
import com.project.portfolio.core.exception.type.NotFoundExceptionType;
import com.project.portfolio.repository.project.Project;
import com.project.portfolio.repository.project.ProjectRepository;
import com.project.portfolio.repository.skill.Skill;
import com.project.portfolio.repository.skill.SkillRepository;
import com.project.portfolio.service.skill.SkillRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.project.portfolio.core.exception.type.NotFoundExceptionType.SKILL_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;
    private final SkillRepository skillRepository;
    private final ProjectRules rules;

    @Override
    public void create(CreateProjectRequest createProjectRequest) {
        rules.check(rules.fix(createProjectRequest));
        Project project = toEntity(createProjectRequest);
        projectRepository.save(project);
    }

    @Override
    public void update(UpdateProjectRequest updateProjectRequest) {
        rules.check(rules.fix(updateProjectRequest));
        Project project = toEntity(updateProjectRequest);
        projectRepository.save(project);
    }

    @Override
    public List<ProjectResponse> getAll() {
        List<Project> projects = projectRepository.findAll();
        rules.checkDataList(projects);
        return projects.stream().map(Project::toResponse).toList();
    }

    @Override
    public ProjectResponse getById(int id) {
        rules.checkData(id);
        return projectRepository.findById(id).orElseThrow().toResponse();
    }

    @Override
    public void delete(int id) {
        rules.checkData(id);
        projectRepository.deleteById(id);
    }

    public Project toEntity(CreateProjectRequest createProjectRequest) {
        List<Skill> skills = createProjectRequest.getSkillIds() != null ? createProjectRequest.getSkillIds().stream()
                .map(skillId -> skillRepository.findById(skillId)
                        .orElseThrow(() ->new DataNotFoundException(SKILL_NOT_FOUND)))
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
                        .orElseThrow(() -> new DataNotFoundException(SKILL_NOT_FOUND)))
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
