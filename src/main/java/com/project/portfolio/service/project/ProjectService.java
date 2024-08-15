package com.project.portfolio.service.project;

import com.project.portfolio.controller.project.request.CreateProjectRequest;
import com.project.portfolio.controller.project.request.UpdateProjectRequest;
import com.project.portfolio.controller.project.response.ProjectResponse;

import java.util.List;

public interface ProjectService {
    void create (CreateProjectRequest createProjectRequest);
    void update (UpdateProjectRequest updateProjectRequest);
    List<ProjectResponse> getAll();
    ProjectResponse getById(int id);
    void delete(int id);

}
