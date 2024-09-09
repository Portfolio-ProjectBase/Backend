package com.project.portfolio.service.password;

import com.project.portfolio.controller.user.request.CreateUserRequest;
import com.project.portfolio.controller.user.response.UserResponse;
import com.project.portfolio.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SecretPasswordService {

    @Autowired
    private UserService userService;

    // 1 dakikada bir şifrelerin süresini kontrol eden görev
    @Scheduled(fixedRate = 60000) // 60 saniyede bir çalışır
    public void deleteExpiredPasswords() {
        List<UserResponse> users = userService.getAll();
        for (UserResponse user : users) {
            if (user.getPasswordCreatedAt() != null && isPasswordExpired(user.getPasswordCreatedAt())) {
                // Şifreyi ve oluşturulma zamanını sıfırlıyoruz
                user.setPassword(null);
                user.setPasswordCreatedAt(null);

                // UserResponse'tan CreateUserRequest'e dönüştürme
                CreateUserRequest createUserRequest = convertToCreateUserRequest(user);
                userService.create(createUserRequest); // Kaydediyoruz
            }
        }
    }

    // Şifre süresi dolmuş mu? (örneğin 1 saat)
    private boolean isPasswordExpired(LocalDateTime passwordCreatedAt) {
        return passwordCreatedAt.plusHours(1).isBefore(LocalDateTime.now());
    }

    // UserResponse'tan CreateUserRequest'e dönüştürme işlemi
    private CreateUserRequest convertToCreateUserRequest(UserResponse userResponse) {
        return CreateUserRequest.builder()
                .name(userResponse.getName())
                .surname(userResponse.getSurname())
                .emailAddress(userResponse.getEmailAddress())
                .password(userResponse.getPassword())
                .aboutMe(userResponse.getAboutMe())
                .detail(userResponse.getDetail())
                .username(userResponse.getUsername())
                .build();
    }
}
