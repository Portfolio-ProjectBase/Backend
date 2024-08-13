package com.project.portfolio.repository.post;

import com.project.portfolio.core.Base;
import com.project.portfolio.repository.skill.Skill;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Posts")
@Entity
public class Post extends Base {
    @Column(name = "title")
    private String title;
    @Column(name = "detail")
    private String detail;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;
}
