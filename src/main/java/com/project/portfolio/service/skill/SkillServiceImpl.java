package com.project.portfolio.service.skill;

import com.project.portfolio.controller.skill.request.CreateSkillRequest;
import com.project.portfolio.controller.skill.request.UpdateSkillRequest;
import com.project.portfolio.controller.skill.response.SkillResponse;
import com.project.portfolio.repository.skill.Skill;
import com.project.portfolio.repository.skill.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService{

    private final SkillRepository skillRepository;

    @Override
    public void create(CreateSkillRequest createSkillRequest) {
        Skill skill = toEntity(createSkillRequest);
        skillRepository.save(skill);
    }

    @Override
    public void update(UpdateSkillRequest updateSkillRequest) {
        Skill skill = toEntity(updateSkillRequest);
        skillRepository.save(skill);
    }

    @Override
    public List<SkillResponse> getAll() {
        List<Skill> skills = skillRepository.findAll();
        return skills.stream().map(Skill::toResponse).toList();
    }

    @Override
    public SkillResponse getById(int id) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Skill not found with id: " + id));
        return skill.toResponse();
    }

    @Override
    public void delete(int id) {
        skillRepository.deleteById(id);
    }

    public Skill toEntity(CreateSkillRequest createSkillRequest) {


        return Skill.builder()
                .name(createSkillRequest.getName())
                .build();
    }

    public Skill toEntity(UpdateSkillRequest updateSkillRequest) {
        return Skill.builder()
                .id(updateSkillRequest.getId())
                .name(updateSkillRequest.getName())
                .build();
    }
}
