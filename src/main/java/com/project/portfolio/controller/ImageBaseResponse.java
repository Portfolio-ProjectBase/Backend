package com.project.portfolio.controller;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class ImageBaseResponse {

    private int id;
    private String imageBase64;

}

