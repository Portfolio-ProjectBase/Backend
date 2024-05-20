package com.project.portfolio.controller.contact.response;

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
public class ContactResponse {

    int id;

    String name;

    String surname;

    String mailAddress;

    String message;
}
