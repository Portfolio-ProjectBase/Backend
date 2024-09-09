package com.project.portfolio.controller.user.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class CreateUserRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String username;
    @NotBlank
    @Email
    private String emailAddress;
    @NotBlank
    private String password;
    @NotBlank
    private String aboutMe;
    @NotBlank
    private String detail;

}
