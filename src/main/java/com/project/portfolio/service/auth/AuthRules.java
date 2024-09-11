package com.project.portfolio.service.auth;

import com.project.portfolio.core.exception.DataNotFoundException;
import com.project.portfolio.core.exception.ValidationException;
import com.project.portfolio.core.exception.type.NotFoundExceptionType;
import com.project.portfolio.repository.user.User;
import com.project.portfolio.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.project.portfolio.core.exception.type.ValidationExceptionType.IMAGE_VALIDATION_FAILED;

@Service
@RequiredArgsConstructor
public class AuthRules {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User findUser() {
        return userRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new DataNotFoundException(NotFoundExceptionType.USER_NOT_FOUND));
    }


    // Kullanıcıyı username ile bul
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() ->  new DataNotFoundException(NotFoundExceptionType.USER_NOT_FOUND));

    }
}
