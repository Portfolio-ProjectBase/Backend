package com.project.portfolio.service.education;


import com.project.portfolio.controller.education.request.CreateEducationRequest;
import com.project.portfolio.controller.education.request.UpdateEducationRequest;
import com.project.portfolio.controller.education.response.EducationResponse;

import java.util.List;

public interface EducationService {
    void create(CreateEducationRequest createEducationRequest);
    void update(UpdateEducationRequest updateEducationRequest);
    List<EducationResponse> getAll();
    EducationResponse getById(int id);
    void delete(int id);
}
