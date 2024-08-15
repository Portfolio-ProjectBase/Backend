package com.project.portfolio.service.user;

import com.project.portfolio.controller.user.request.CreateUserRequest;
import com.project.portfolio.controller.user.request.UpdateUserRequest;
import com.project.portfolio.controller.user.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    void create(CreateUserRequest createUserRequest);
    void update(UpdateUserRequest updateUserRequest);
    List<UserResponse> getAll();
    UserResponse getById(int id);
    void delete(int id);
}
