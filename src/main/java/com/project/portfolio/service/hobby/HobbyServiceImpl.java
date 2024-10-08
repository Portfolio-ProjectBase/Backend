package com.project.portfolio.service.hobby;

import com.project.portfolio.controller.hobby.request.CreateHobbyRequest;
import com.project.portfolio.controller.hobby.request.UpdateHobbyRequest;
import com.project.portfolio.controller.hobby.response.HobbyResponse;
import com.project.portfolio.repository.hobby.Hobby;
import com.project.portfolio.repository.hobby.HobbyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HobbyServiceImpl implements HobbyService{

    private final HobbyRepository hobbyRepository;

    @Override
    public void create(CreateHobbyRequest hobbyRequest) {

        hobbyRepository.save(toEntity(hobbyRequest));

    }

    @Override
    public void update(UpdateHobbyRequest hobbyRequest) {

        getById(hobbyRequest.getId());
        hobbyRepository.save(toEntity(hobbyRequest));

    }

    @Override
    public List<HobbyResponse> getAll() {

        List<Hobby> hobbies = hobbyRepository.findAll();
        return hobbies.stream().map(Hobby::toResponse).toList();

    }

    @Override
    public HobbyResponse getById(int id) {

        return hobbyRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Hobby not found with id: " + id))
                .toResponse();

    }

    @Override
    public void delete(int id) {

        hobbyRepository.deleteById(id);

    }

    public Hobby toEntity(CreateHobbyRequest hobbyRequest){
        return Hobby.builder()
                .name(hobbyRequest.getName())
                .build();
    }

    public Hobby toEntity(UpdateHobbyRequest hobbyRequest){
        return Hobby.builder()
                .id(hobbyRequest.getId())
                .name(hobbyRequest.getName())
                .build();
    }
}
