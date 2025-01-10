package com.project.portfolio.service.skill;

import com.project.portfolio.controller.project.response.PagedResponse;
import com.project.portfolio.controller.skill.request.CreateSkillRequest;
import com.project.portfolio.controller.skill.request.UpdateSkillRequest;
import com.project.portfolio.controller.skill.response.SkillResponse;
import com.project.portfolio.core.exception.DataNotFoundException;
import com.project.portfolio.core.exception.type.NotFoundExceptionType;
import com.project.portfolio.repository.project.Project;
import com.project.portfolio.repository.skill.Skill;
import com.project.portfolio.repository.skill.SkillRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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
        Skill existingSkill = skillRepository.findById(updateSkillRequest.getId())
                .orElseThrow(() -> new DataNotFoundException(NotFoundExceptionType.SKILL_NOT_FOUND));
        if (updateSkillRequest.getIsGetNewPicture() && updateSkillRequest.getImage() != null) {
            existingSkill.setImage(updateSkillRequest.getImage()); // Yeni resmi ayarla
            System.out.println("New image set to existingSkill");
        }
        Skill updatedSkill = toEntity(updateSkillRequest);
        updatedSkill.setId(existingSkill.getId()); // ID aynı kalmalı
        if (!updateSkillRequest.getIsGetNewPicture()) {
            updatedSkill.setImage(existingSkill.getImage()); // Yeni resim yoksa eski resmi koru
            System.out.println("Existing image preserved");
        }
        skillRepository.save(updatedSkill);
    }

    @Override
    public PagedResponse<SkillResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Skill> skillsPage = skillRepository.findAll(pageable);

        // Listeyi dönüştür
        List<SkillResponse> skillResponses = skillsPage
                .getContent()
                .stream()
                .map(Skill::toResponse)
                .toList();

        // Sayfalama bilgilerini ekle
        return new PagedResponse<>(
                skillResponses,
                skillsPage.getNumber(),        // Mevcut sayfa numarası
                skillsPage.getSize(),          // Sayfa boyutu
                skillsPage.getTotalPages(),    // Toplam sayfa sayısı
                skillsPage.getTotalElements(), // Toplam eleman sayısı
                skillsPage.isLast()            // Son sayfa kontrolü
        );
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
                .image(updateSkillRequest.getIsGetNewPicture() ? updateSkillRequest.getImage() : null)
                .isGetNewPicture(updateSkillRequest.getIsGetNewPicture())
                .build();
    }
}
