package com.project.portfolio.controller.project;

import com.project.portfolio.controller.BaseController;
import com.project.portfolio.controller.project.request.CreateProjectRequest;
import com.project.portfolio.controller.project.request.UpdateProjectRequest;
import com.project.portfolio.controller.project.response.PagedResponse;
import com.project.portfolio.controller.project.response.ProjectResponse;
import com.project.portfolio.service.project.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/projects")
@RequiredArgsConstructor
public class ProjectController extends BaseController {
    private final ProjectService projectService;

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Void> createProject(@Valid
                                                  @RequestParam String title,
                                                  @RequestParam LocalDate projectDate,
                                                  @RequestParam String detail,
                                                  @RequestParam String liveSiteLink,
                                                  @RequestParam String githubLink,
                                                  @RequestParam List<Integer> skillIds,
                                                  @RequestPart(value = "image", required = false) MultipartFile image) {
        CreateProjectRequest projectRequest = new CreateProjectRequest();
        projectRequest.setTitle(title);
        projectRequest.setDetail(detail);
        projectRequest.setProjectDate(projectDate);
        projectRequest.setLiveSiteLink(liveSiteLink);
        projectRequest.setGithubLink(githubLink);
        projectRequest.setSkillIds(skillIds);
        if (image != null) {
            try {
                projectRequest.setImage(image.getBytes());
            } catch (IOException e) {
                return answer(HttpStatus.BAD_REQUEST); // Resim yükleme hatası durumunda
            }
        }
        projectService.create(projectRequest);
        return answer(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable int id) {
        ProjectResponse response = projectService.getById(id);
        return answer(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<PagedResponse<ProjectResponse>> getAllProjects(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        PagedResponse<ProjectResponse> response = projectService.getAll(page, size);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Void> updateProject(@Valid
                                                  @RequestParam("id") int id,
                                                  @RequestParam String title,
                                                  @RequestParam LocalDate projectDate,
                                                  @RequestParam String detail,
                                                  @RequestParam String liveSiteLink,
                                                  @RequestParam String githubLink,
                                                  @RequestParam List<Integer> skillIds,
                                                  @RequestPart(value = "image", required = false) MultipartFile image
                                                  ) {
        UpdateProjectRequest request = new UpdateProjectRequest();
        request.setId(id);
        request.setTitle(title);
        request.setDetail(detail);
        request.setProjectDate(projectDate);
        request.setLiveSiteLink(liveSiteLink);
        request.setGithubLink(githubLink);
        request.setSkillIds(skillIds);
        if (image != null) {
            try {
                request.setImage(image.getBytes());
            } catch (IOException e) {
                return answer(HttpStatus.BAD_REQUEST); // Resim yükleme hatası durumunda
            }
        }
        projectService.update(request);
        return answer(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable int id) {
        projectService.delete(id);
        return answer(HttpStatus.NO_CONTENT);
    }
}
