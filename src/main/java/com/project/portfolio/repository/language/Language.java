package com.project.portfolio.repository.language;

import com.project.portfolio.core.Base;
import com.project.portfolio.repository.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Table(name = "Languages")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@SuperBuilder
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
