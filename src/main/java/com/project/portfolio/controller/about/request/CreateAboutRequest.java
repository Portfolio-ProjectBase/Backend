package com.project.portfolio.controller.about.request;


import com.project.portfolio.controller.card.request.CreateCardRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateAboutRequest {
    private String aboutText;
    private List<CreateCardRequest> cards;
}
