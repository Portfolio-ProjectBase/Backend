package com.project.portfolio.service.education;

import com.project.portfolio.controller.education.request.CreateEducationRequest;
import com.project.portfolio.controller.education.request.UpdateEducationRequest;
import com.project.portfolio.controller.education.response.EducationResponse;
import com.project.portfolio.repository.education.Education;
import com.project.portfolio.repository.education.EducationRepository;
import com.project.portfolio.repository.user.User;
import com.project.portfolio.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationServiceImpl implements EducationService{
    private final EducationRepository repository;
    @Override
    public void create(CreateEducationRequest createEducationRequest) {
        repository.save(toEntity(createEducationRequest));
    }

    @Override
    public void update(UpdateEducationRequest updateEducationRequest) {
        repository.save(toEntity(updateEducationRequest));
    }

    @Override
    public List<EducationResponse> getAll() {
        List<Education> educations = repository.findAll();
        return educations.stream().map(Education::toResponse).toList();
    }

    @Override
    public EducationResponse getById(int id) {
        return repository.findById(id).orElseThrow().toResponse();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
    public Education toEntity(CreateEducationRequest request){
        return Education.builder()
                .name(request.getName())
                .startDate(request.getStartDate())
                .finishDate(request.getFinishDate())
                .major(request.getMajor())
                .build();
    }
    public Education toEntity(UpdateEducationRequest request){
        return Education.builder()
                .id(request.getId())
                .name(request.getName())
                .startDate(request.getStartDate())
                .finishDate(request.getFinishDate())
                .major(request.getMajor())
                .build();
    }
}
