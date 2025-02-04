package com.project.portfolio.controller.about.response;

import com.project.portfolio.controller.card.request.CreateCardRequest;
import com.project.portfolio.controller.card.response.CardResponse;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AboutResponse {
    @NotNull
    private int id;
    private String aboutText;
    private List<CardResponse> cards;
}
