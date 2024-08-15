package com.project.portfolio.service.experience;

import com.project.portfolio.controller.experience.request.CreateExperienceRequest;
import com.project.portfolio.controller.experience.request.UpdateExperienceRequest;
import com.project.portfolio.controller.experience.response.ExperienceResponse;

import java.util.List;

public interface ExperienceService {
    void create(CreateExperienceRequest createExperienceRequest);
    void update(UpdateExperienceRequest updateExperienceRequest);
    List<ExperienceResponse> getAll();
    ExperienceResponse getById(int id);
    void delete(int id);
}
