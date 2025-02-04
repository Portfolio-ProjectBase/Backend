package com.project.portfolio.controller.card.response;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CardResponse {
    private int id;
    private String title;
    private String description;
}
