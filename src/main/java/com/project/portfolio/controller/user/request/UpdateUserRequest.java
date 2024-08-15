package com.project.portfolio.controller.user.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateUserRequest {
    @NotNull
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String emailAddress;
    @NotBlank
    private String password;
    @NotBlank
    private String aboutMe;
    @NotBlank
    private String detail;
}
