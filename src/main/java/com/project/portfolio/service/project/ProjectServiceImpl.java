package com.project.portfolio.service.project;

import com.project.portfolio.controller.project.request.CreateProjectRequest;
import com.project.portfolio.controller.project.request.UpdateProjectRequest;
import com.project.portfolio.controller.project.response.ProjectResponse;
import com.project.portfolio.repository.project.Project;
import com.project.portfolio.repository.project.ProjectRepository;
import com.project.portfolio.repository.user.User;
import com.project.portfolio.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService{

    private final ProjectRepository projectRepository;
    private final UserService userService;

    @Override
    public void create(CreateProjectRequest createProjectRequest) {
       projectRepository.save(toEntity(createProjectRequest));
    }

    @Override
    public void update(UpdateProjectRequest updateProjectRequest) {
      projectRepository.save(toEntity(updateProjectRequest));
    }

    @Override
    public List<ProjectResponse> getAll() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream().map(Project::toResponse).toList();
    }

    @Override
    public ProjectResponse getById(int id) {
        return projectRepository.findById(id).orElseThrow().toResponse();
    }

    @Override
    public void delete(int id) {
        projectRepository.deleteById(id);
    }

    public Project toEntity(CreateProjectRequest createProjectRequest){
        return Project.builder()
                .title(createProjectRequest.getTitle())
                .detail((createProjectRequest.getDetail()))
                .projectDate(createProjectRequest.getProjectDate())
                .liveSiteLink(createProjectRequest.getLiveSiteLink())
                .githubLink(createProjectRequest.getGithubLink())
                .user(User.fromResponse(userService.getById(createProjectRequest.getUserId())))
                .build();
    }

    public Project toEntity(UpdateProjectRequest updateProjectRequest){
        return Project.builder()
                .id(updateProjectRequest.getId())
                .title(updateProjectRequest.getTitle())
                .detail((updateProjectRequest.getDetail()))
                .projectDate(updateProjectRequest.getProjectDate())
                .liveSiteLink(updateProjectRequest.getLiveSiteLink())
                .githubLink(updateProjectRequest.getGithubLink())
                .user(User.fromResponse(userService.getById(updateProjectRequest.getUserId())))
                .build();
    }
}
