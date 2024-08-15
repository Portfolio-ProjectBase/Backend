package com.project.portfolio.service.resume;

import com.project.portfolio.controller.resume.request.CreateResumeRequest;
import com.project.portfolio.controller.resume.request.UpdateResumeRequest;
import com.project.portfolio.controller.resume.response.ResumeResponse;

import java.util.List;

public interface ResumeService {

    void create(CreateResumeRequest resumeRequest);
    void update(UpdateResumeRequest resumeRequest);
    List<ResumeResponse> getAll();
    ResumeResponse getById(int id);
    void delete(int id);
}
