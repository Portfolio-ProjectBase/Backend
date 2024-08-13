package com.project.portfolio.repository.language;

import com.project.portfolio.core.Base;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Table(name = "LanguageLevels")
public class LanguageLevel extends Base {

    @Column(name = "name")
    private String name;
    @Column(name = "level")
    private int level;
}
