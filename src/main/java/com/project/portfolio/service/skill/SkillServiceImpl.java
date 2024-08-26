package com.project.portfolio.service.skill;

import com.project.portfolio.controller.skill.request.CreateSkillRequest;
import com.project.portfolio.controller.skill.request.UpdateSkillRequest;
import com.project.portfolio.controller.skill.response.SkillResponse;
import com.project.portfolio.core.exception.DataNotFoundException;
import com.project.portfolio.core.exception.type.NotFoundExceptionType;
import com.project.portfolio.repository.skill.Skill;
import com.project.portfolio.repository.skill.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;

import static com.project.portfolio.core.exception.type.NotFoundExceptionType.SKILL_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService {

    private final SkillRepository skillRepository;
    private final SkillRules skillRules;

    @Override
    public void create(CreateSkillRequest createSkillRequest) {
        skillRules.check(skillRules.fix(createSkillRequest));
        Skill skill = toEntity(createSkillRequest);
        skillRepository.save(skill);
    }

    @Override
    public void update(UpdateSkillRequest updateSkillRequest) {
        skillRules.check(skillRules.fix(updateSkillRequest));
        Skill skill = toEntity(updateSkillRequest);
        skillRepository.save(skill);
    }

    @Override
    public List<SkillResponse> getAll() {
        List<Skill> skills = skillRepository.findAll();
        skillRules.checkDataList(skills);
        return skills.stream().map(Skill::toResponse).toList();
    }

    @Override
    public SkillResponse getById(int id) {
        skillRules.checkData(id);
        return skillRepository.findById(id).orElseThrow().toResponse();
    }

    @Override
    public void delete(int id) {
        skillRules.checkData(id);
        skillRepository.deleteById(id);
    }

    public Skill toEntity(CreateSkillRequest createSkillRequest) {
        return Skill.builder()
                .name(createSkillRequest.getName())
                .image(createSkillRequest.getImage()) // Resmi byte[] olarak saklar
                .build();
    }

    public Skill toEntity(UpdateSkillRequest updateSkillRequest) {
        return Skill.builder()
                .id(updateSkillRequest.getId())
                .name(updateSkillRequest.getName())
                .image(updateSkillRequest.getImage()) // Resmi byte[] olarak günceller
                .build();
    }
}
