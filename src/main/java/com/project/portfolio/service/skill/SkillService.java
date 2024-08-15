package com.project.portfolio.service.skill;

import com.project.portfolio.controller.skill.request.CreateSkillRequest;
import com.project.portfolio.controller.skill.request.UpdateSkillRequest;
import com.project.portfolio.controller.skill.response.SkillResponse;

import java.util.List;

public interface SkillService {
    void create (CreateSkillRequest createSkillRequest);
    void update (UpdateSkillRequest updateSkillRequest);
    List<SkillResponse> getAll();
    SkillResponse getById(int id);
    void delete(int id);
}
