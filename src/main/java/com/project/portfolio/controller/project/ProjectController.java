package com.project.portfolio.controller.project;

import com.project.portfolio.controller.BaseController;
import com.project.portfolio.controller.project.request.CreateProjectRequest;
import com.project.portfolio.controller.project.request.UpdateProjectRequest;
import com.project.portfolio.controller.project.response.ProjectResponse;
import com.project.portfolio.service.project.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
public class ProjectController extends BaseController {
    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<Void> createProject(@RequestBody CreateProjectRequest request) {
        projectService.create(request);
        return answer(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable int id) {
        ProjectResponse response = projectService.getById(id);
        return answer(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProjectResponse>> getAllProjects() {
        List<ProjectResponse> responses = projectService.getAll();
        return answer(responses, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateProject(@RequestBody UpdateProjectRequest request) {
        projectService.update(request);
        return answer(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable int id) {
        projectService.delete(id);
        return answer(HttpStatus.NO_CONTENT);
    }
}
