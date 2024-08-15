package com.project.portfolio.controller.reference.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ReferenceResponse {
    private String name;
    private String surname;
    private String emailAddress;
}
