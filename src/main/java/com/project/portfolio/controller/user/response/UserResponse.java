package com.project.portfolio.controller.user.response;

import lombok.*;

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
}
