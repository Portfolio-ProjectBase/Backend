package com.project.portfolio.repository.education;

import com.project.portfolio.core.Base;
import com.project.portfolio.repository.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Education")
public class Education extends Base {
    @Column(name = "name")
    private String name;
    @Column(name = "startDate")
    private Date startDate;
    @Column(name = "finishDate")
    private Date finishDate;
    @Column(name = "major")
    private String major;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
