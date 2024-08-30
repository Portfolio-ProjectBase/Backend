package com.project.portfolio.service.skill;

import com.project.portfolio.controller.skill.request.CreateSkillRequest;
import com.project.portfolio.controller.skill.request.UpdateSkillRequest;
import com.project.portfolio.core.exception.AlreadyExistsException;
import com.project.portfolio.core.exception.DataNotFoundException;
import com.project.portfolio.core.exception.ValidationException;
import com.project.portfolio.repository.skill.SkillRepository;
import com.project.portfolio.service.BaseRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.portfolio.core.exception.type.AlreadyExistsExceptionType.SKILL_EXISTS;
import static com.project.portfolio.core.exception.type.NotFoundExceptionType.SKILL_LIST_NOT_FOUND;
import static com.project.portfolio.core.exception.type.NotFoundExceptionType.SKILL_NOT_FOUND;
import static com.project.portfolio.core.exception.type.ValidationExceptionType.IMAGE_VALIDATION_FAILED;
import static com.project.portfolio.service.ImageRules.validateImage;

@Service
@RequiredArgsConstructor
public class SkillRules implements BaseRules {

    private final SkillRepository skillRepository;

    @Override
    public void checkDataList(List<?> list) {

        if (list.isEmpty()){
            throw new DataNotFoundException(SKILL_LIST_NOT_FOUND);
        }

    }

    public void checkData(int id){
        if(!skillRepository.existsById(id)){
            throw new DataNotFoundException(SKILL_NOT_FOUND);
        }
    }

    public CreateSkillRequest fix(CreateSkillRequest skillRequest){
        skillRequest.setName(fixName(skillRequest.getName()));
        return skillRequest;
    }

    public UpdateSkillRequest fix(UpdateSkillRequest skillRequest){
        skillRequest.setName(fixName((skillRequest.getName())));
        return skillRequest;
    }

    public void check(CreateSkillRequest skillRequest){
        isExistsByName(skillRequest.getName());
        if (skillRequest.getImage() != null) {
            validateImage(skillRequest.getImage()); // Image validation with optional check
        }
        else{
            throw new ValidationException(IMAGE_VALIDATION_FAILED);
        }
    }

    public void check(UpdateSkillRequest skillRequest){
        isExistsByNameAndIdNot(skillRequest.getName(), skillRequest.getId());
        if (skillRequest.getImage() != null) {
            validateImage(skillRequest.getImage()); // Image validation with optional check
        }
        else{
            throw new ValidationException(IMAGE_VALIDATION_FAILED);
        }
    }

    @Override
    public String fixName(String name) {
        return name;
    }

    @Override
    public void isExistsByName(String name) {
        if(skillRepository.existsByName(name)){
            throw new AlreadyExistsException(SKILL_EXISTS);
        }
    }

    @Override
    public void isExistsByNameAndIdNot(String name, int id) {
        if(skillRepository.existsByNameAndIdNot(name, id)){
            throw new AlreadyExistsException(SKILL_EXISTS);
        }
    }

}
