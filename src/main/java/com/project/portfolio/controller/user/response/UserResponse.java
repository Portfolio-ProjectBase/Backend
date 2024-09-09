package com.project.portfolio.controller.user.response;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserResponse {
    int id;
    String name;
    String surname;
    String emailAddress;
    String password;
    String aboutMe;
    String detail;
    String username;
    LocalDateTime passwordCreatedAt;
}
