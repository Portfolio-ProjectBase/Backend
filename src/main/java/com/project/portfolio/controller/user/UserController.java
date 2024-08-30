package com.project.portfolio.controller.user;

import com.project.portfolio.controller.BaseController;
import com.project.portfolio.controller.user.request.UpdateUserRequest;
import com.project.portfolio.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController extends BaseController {

    private final UserService userService;

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody UpdateUserRequest userRequest){

        userService.update(userRequest);
        return answer(HttpStatus.NO_CONTENT);

    }
}
