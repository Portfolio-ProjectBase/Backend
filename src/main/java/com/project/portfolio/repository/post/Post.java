package com.project.portfolio.repository.post;

import com.project.portfolio.core.Base;
import com.project.portfolio.repository.skill.Skill;
import com.project.portfolio.repository.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @OneToMany(mappedBy = "post")
    private List<Skill> skills;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
