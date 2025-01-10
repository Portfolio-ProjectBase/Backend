package com.project.portfolio.service.experience;

import com.project.portfolio.controller.experience.request.CreateExperienceRequest;
import com.project.portfolio.controller.experience.request.UpdateExperienceRequest;
import com.project.portfolio.controller.experience.response.ExperienceResponse;
import com.project.portfolio.controller.project.response.PagedResponse;

import java.util.List;

public interface ExperienceService {
    void create(CreateExperienceRequest createExperienceRequest);
    void update(UpdateExperienceRequest updateExperienceRequest);
    PagedResponse<ExperienceResponse> getAll(int page, int size);
    ExperienceResponse getById(int id);
    void delete(int id);
}
