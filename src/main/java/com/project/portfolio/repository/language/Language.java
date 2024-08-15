package com.project.portfolio.repository.language;

import com.project.portfolio.core.Base;
import com.project.portfolio.repository.user.User;
import jakarta.persistence.*;

@Table(name = "Languages")
public class Language extends Base {

    @Column(name = "name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "level_id")
    private LanguageLevel languageLevel;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
