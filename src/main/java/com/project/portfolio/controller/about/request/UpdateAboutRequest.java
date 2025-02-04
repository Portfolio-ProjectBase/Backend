package com.project.portfolio.controller.about.request;

import com.project.portfolio.controller.card.request.CreateCardRequest;
import com.project.portfolio.controller.card.request.UpdateCardRequest;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateAboutRequest {
    @NotNull
    private int id;
    private String aboutText;
    private List<UpdateCardRequest> cards;
}
