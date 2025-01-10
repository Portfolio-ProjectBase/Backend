package com.project.portfolio.service.skill;

import com.project.portfolio.controller.project.response.PagedResponse;
import com.project.portfolio.controller.project.response.ProjectResponse;
import com.project.portfolio.controller.skill.request.CreateSkillRequest;
import com.project.portfolio.controller.skill.request.UpdateSkillRequest;
import com.project.portfolio.controller.skill.response.SkillResponse;

import java.util.List;

public interface SkillService {
    void create (CreateSkillRequest createSkillRequest);
    void update (UpdateSkillRequest updateSkillRequest);
    PagedResponse<SkillResponse> getAll(int page, int size);
    SkillResponse getById(int id);
    void delete(int id);
}
