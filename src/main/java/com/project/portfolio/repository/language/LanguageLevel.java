package com.project.portfolio.repository.language;

import com.project.portfolio.controller.language.languageLevel.response.LanguageLevelResponse;
import com.project.portfolio.core.Base;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Table(name = "LanguageLevels")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@SuperBuilder
public class LanguageLevel extends Base {

    @Column(name = "name")
    private String name;
    @Column(name = "level")
    private int level;

    public LanguageLevelResponse toResponse(){
        return LanguageLevelResponse.builder()
                .id(getId())
                .name(getName())
                .level(getLevel())
                .build();
    }

    public static LanguageLevel fromResponse(LanguageLevelResponse languageLevelResponse){
        return LanguageLevel.builder()
                .id(languageLevelResponse.getId())
                .name(languageLevelResponse.getName())
                .level(languageLevelResponse.getLevel())
                .build();
    }
}
