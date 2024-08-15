package com.project.portfolio.controller.language.languageLevel.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LanguageLevelResponse {

    private int id;
    private String name;
    private int level;
}
