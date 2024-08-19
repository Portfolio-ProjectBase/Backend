package com.project.portfolio.controller.hobby.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateHobbyRequest {

    @NotBlank
    private String name;


}
