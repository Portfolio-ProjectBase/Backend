package com.project.portfolio.repository.blog;

import com.project.portfolio.core.Base;
import com.project.portfolio.repository.skill.Skill;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Blogs")
@Entity
public class Blog extends Base {
    @Column(name = "title")
    private String title;
    @Column(name = "detail")
    private String detail;

    @Column(name = "create_date")
    private LocalDate createDate;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;
}
