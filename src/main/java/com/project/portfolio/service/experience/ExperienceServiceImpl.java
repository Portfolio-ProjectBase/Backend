package com.project.portfolio.service.experience;

import com.project.portfolio.controller.experience.request.CreateExperienceRequest;
import com.project.portfolio.controller.experience.request.UpdateExperienceRequest;
import com.project.portfolio.controller.experience.response.ExperienceResponse;
import com.project.portfolio.controller.project.response.PagedResponse;
import com.project.portfolio.repository.experience.Experience;
import com.project.portfolio.repository.experience.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExperienceServiceImpl implements ExperienceService{
    private final ExperienceRepository repository;

    @Override
    public void create(CreateExperienceRequest createExperienceRequest) {
        repository.save(toEntity(createExperienceRequest));
    }

    @Override
    public void update(UpdateExperienceRequest updateExperienceRequest) {
        repository.save(toEntity(updateExperienceRequest));
    }

    @Override
    public PagedResponse<ExperienceResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Experience> experiencesPage = repository.findAll(pageable);
        List<ExperienceResponse> experienceResponses = experiencesPage
                .getContent()
                .stream()
                .map(Experience::toResponse)
                .toList();
        return new PagedResponse<>(
                experienceResponses,
                experiencesPage.getNumber(),        // Mevcut sayfa numarası
                experiencesPage.getSize(),          // Sayfa boyutu
                experiencesPage.getTotalPages(),    // Toplam sayfa sayısı
                experiencesPage.getTotalElements(), // Toplam eleman sayısı
                experiencesPage.isLast()            // Son sayfa kontrolü
        );
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
