package com.project.portfolio.service.user;

import com.project.portfolio.controller.user.request.CreateUserRequest;
import com.project.portfolio.controller.user.request.UpdateUserRequest;
import com.project.portfolio.controller.user.response.UserResponse;
import com.project.portfolio.repository.user.User;
import com.project.portfolio.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository repository;

    @Override
    public void create(CreateUserRequest createUserRequest) {
        repository.save(toEntity(createUserRequest));
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        repository.save(toEntity(updateUserRequest));
    }

    @Override
    public List<UserResponse> getAll() {
        List<User> userList = repository.findAll();
        List<UserResponse> userResponses = userList.stream().map(user -> user.toResponse()).toList();
        return userResponses;
    }

    @Override
    public UserResponse getById(int id) {
        UserResponse users= repository.findById(id).orElseThrow().toResponse();
        return users;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }

    public User toEntity(CreateUserRequest request){
        return User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .aboutMe(request.getAboutMe())
                .password(request.getPassword())
                .emailAddress(request.getEmailAddress())
                .detail(request.getDetail())
                .build();
    }
    public User toEntity(UpdateUserRequest request){
        return User.builder()
                .id(request.getId())
                .name(request.getName())
                .surname(request.getSurname())
                .aboutMe(request.getAboutMe())
                .password(request.getPassword())
                .emailAddress(request.getEmailAddress())
                .detail(request.getDetail())
                .build();
    }
}
