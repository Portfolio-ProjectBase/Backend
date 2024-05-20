package com.project.portfolio.controller.contact.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateContactRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String mailAddress;
    @NotBlank
    private String message;
}
