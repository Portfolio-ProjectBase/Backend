package com.project.portfolio.service.experience;

import com.project.portfolio.controller.experience.request.CreateExperienceRequest;
import com.project.portfolio.controller.experience.request.UpdateExperienceRequest;
import com.project.portfolio.controller.experience.response.ExperienceResponse;
import com.project.portfolio.repository.experience.Experience;
import com.project.portfolio.repository.experience.ExperienceRepository;
import com.project.portfolio.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService{
    private final ExperienceRepository repository;
    private final UserService userService;

    @Override
    public void create(CreateExperienceRequest createExperienceRequest) {
        repository.save(toEntity(createExperienceRequest));
    }

    @Override
    public void update(UpdateExperienceRequest updateExperienceRequest) {
        repository.save(toEntity(updateExperienceRequest));
    }

    @Override
    public List<ExperienceResponse> getAll() {
        List<Experience> experiences = repository.findAll();
       return experiences.stream().map(Experience::toResponse).toList();
    }

    @Override
    public ExperienceResponse getById(int id) {
        return repository.findById(id).orElseThrow().toResponse();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
    public Experience toEntity(CreateExperienceRequest request){
            return Experience.builder()
                    .departmentTitle(request.getDepartmentTitle())
                    .workplace(request.getWorkplace())
                    .startDate(request.getStartDate())
                    .finishDate(request.getFinishDate())
                    .detail(request.getDetail())
                    .position(request.getPosition())
                    .build();

    }
    public Experience toEntity(UpdateExperienceRequest request){
        return Experience.builder()
                .id(request.getId())
                .departmentTitle(request.getDepartmentTitle())
                .workplace(request.getWorkplace())
                .startDate(request.getStartDate())
                .finishDate(request.getFinishDate())
                .detail(request.getDetail())
                .position(request.getPosition())
                .build();
    }
}
