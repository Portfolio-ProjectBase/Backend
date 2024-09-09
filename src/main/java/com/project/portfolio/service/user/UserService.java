package com.project.portfolio.service.user;

import com.project.portfolio.controller.user.request.CreateUserRequest;
import com.project.portfolio.controller.user.request.UpdateUserRequest;
import com.project.portfolio.controller.user.response.UserResponse;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;


public interface UserService extends UserDetailsService {
    void create(CreateUserRequest createUserRequest);
    void update(UpdateUserRequest updateUserRequest);
    List<UserResponse> getAll();
    UserResponse getById(int id);
    UserResponse getByUsername(String username);
    void delete(int id);
}
