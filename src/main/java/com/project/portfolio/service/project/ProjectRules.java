package com.project.portfolio.service.project;

import com.project.portfolio.controller.project.request.CreateProjectRequest;
import com.project.portfolio.controller.project.request.UpdateProjectRequest;
import com.project.portfolio.core.exception.AlreadyExistsException;
import com.project.portfolio.core.exception.DataNotFoundException;
import com.project.portfolio.core.exception.ValidationException;
import com.project.portfolio.repository.project.ProjectRepository;
import com.project.portfolio.service.BaseRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.portfolio.core.exception.type.AlreadyExistsExceptionType.PROJECT_EXISTS;
import static com.project.portfolio.core.exception.type.NotFoundExceptionType.PROJECT_LIST_NOT_FOUND;
import static com.project.portfolio.core.exception.type.NotFoundExceptionType.PROJECT_NOT_FOUND;
import static com.project.portfolio.core.exception.type.ValidationExceptionType.IMAGE_VALIDATION_FAILED;
import static com.project.portfolio.service.ImageRules.validateImage;

@Service
@RequiredArgsConstructor
public class ProjectRules implements BaseRules {
    private final ProjectRepository projectRepository;

    public CreateProjectRequest fix(CreateProjectRequest request){
        request.setTitle(fixName(request.getTitle()));
        return request;
    }
    public UpdateProjectRequest fix(UpdateProjectRequest request){
        request.setTitle(fixName(request.getTitle()));
        return request;
    }
    public void check(CreateProjectRequest request){
        isExistsByName(request.getTitle());
        if (request.getImage() != null) {
            validateImage(request.getImage()); // Image validation with optional check
        }
        else {
            throw new ValidationException(IMAGE_VALIDATION_FAILED);
        }

    }
    public void check(UpdateProjectRequest request){
        isExistsByNameAndIdNot(request.getTitle(),request.getId());
        if (request.getIsGetNewPicture()) {
            if (request.getImage() != null) {
                validateImage(request.getImage());
            } else {
                throw new ValidationException(IMAGE_VALIDATION_FAILED);
            }
        }
    }
    @Override
    public void checkDataList(List<?> list) {
        if (list.isEmpty()){
            throw new DataNotFoundException(PROJECT_LIST_NOT_FOUND);
        }
    }

    @Override
    public String fixName(String name) {
        return name;
    }

    @Override
    public void isExistsByName(String name) {
        if (projectRepository.existsByTitle(name))
        {
            throw new AlreadyExistsException(PROJECT_EXISTS);
        }
    }

    @Override
    public void isExistsByNameAndIdNot(String name, int id) {
        if (projectRepository.existsByTitleAndIdNot(name,id))
        {
            throw new AlreadyExistsException(PROJECT_EXISTS);
        }
    }

    @Override
    public void checkData(int id) {
        if(!projectRepository.existsById(id)){
            throw new DataNotFoundException(PROJECT_NOT_FOUND);
        }
    }
}
