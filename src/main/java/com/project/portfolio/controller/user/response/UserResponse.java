package com.project.portfolio.controller.user.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {
    int id;
    String name;
    String surname;
    String role;
    String emailAddress;
    private String resumeUrl;
}
