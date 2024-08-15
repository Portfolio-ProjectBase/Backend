package com.project.portfolio.service.hobby;

import com.project.portfolio.controller.hobby.request.CreateHobbyRequest;
import com.project.portfolio.controller.hobby.request.UpdateHobbyRequest;
import com.project.portfolio.controller.hobby.response.HobbyResponse;
import com.project.portfolio.repository.hobby.Hobby;
import com.project.portfolio.repository.hobby.HobbyRepository;
import com.project.portfolio.repository.user.User;
import com.project.portfolio.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HobbyServiceImpl implements HobbyService{

    private final HobbyRepository hobbyRepository;
    private final UserService userService;

    @Override
    public void create(CreateHobbyRequest hobbyRequest) {

        hobbyRepository.save(toEntity(hobbyRequest));

    }

    @Override
    public void update(UpdateHobbyRequest hobbyRequest) {

        hobbyRepository.save(toEntity(hobbyRequest));

    }

    @Override
    public List<HobbyResponse> getAll() {

        List<Hobby> hobbies = hobbyRepository.findAll();
        return hobbies.stream().map(Hobby::toResponse).toList();

    }

    @Override
    public HobbyResponse getById(int id) {

        return hobbyRepository.findById(id).orElseThrow().toResponse();

    }

    @Override
    public void delete(int id) {

        hobbyRepository.deleteById(id);

    }

    public Hobby toEntity(CreateHobbyRequest hobbyRequest){
        return Hobby.builder()
                .name(hobbyRequest.getName())
                .user(User.fromResponse(userService.getById(hobbyRequest.getUserId())))
                .build();
    }

    public Hobby toEntity(UpdateHobbyRequest hobbyRequest){
        return Hobby.builder()
                .id(hobbyRequest.getId())
                .name(hobbyRequest.getName())
                .user(User.fromResponse(userService.getById(hobbyRequest.getUserId())))
                .build();
    }
}
