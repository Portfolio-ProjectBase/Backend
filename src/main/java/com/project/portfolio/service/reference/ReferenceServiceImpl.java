package com.project.portfolio.service.reference;

import com.project.portfolio.controller.reference.request.CreateReferenceRequest;
import com.project.portfolio.controller.reference.request.UpdateReferenceRequest;
import com.project.portfolio.controller.reference.response.ReferenceResponse;
import com.project.portfolio.repository.reference.ReferenceRepository;
import com.project.portfolio.repository.reference.Reference;
import com.project.portfolio.repository.user.User;
import com.project.portfolio.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReferenceServiceImpl implements ReferenceService{
    private final ReferenceRepository repository;
    private final UserService userService;

    @Override
    public void create(CreateReferenceRequest createReferenceRequest) {
        repository.save(toEntity(createReferenceRequest));
    }

    @Override
    public void update(UpdateReferenceRequest updateReferenceRequest) {
        repository.save(toEntity(updateReferenceRequest));
    }

    @Override
    public List<ReferenceResponse> getAll() {
        List<Reference> references = repository.findAll();
        return references.stream().map(Reference::toResponse).toList();
    }

    @Override
    public ReferenceResponse getById(int id) {
        return repository.findById(id).orElseThrow().toResponse();
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    public Reference toEntity(CreateReferenceRequest request){
        return Reference.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .emailAddress(request.getEmailAddress())
                .build();
    }
    public Reference toEntity(UpdateReferenceRequest request){
        return Reference.builder()
                .id(request.getId())
                .name(request.getName())
                .surname(request.getSurname())
                .emailAddress(request.getEmailAddress())
                .build();
    }
}
