package com.project.portfolio.controller.user.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateUserRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String role;
    @NotBlank
    private String emailAddress;
    @NotBlank
    private String password;

}
