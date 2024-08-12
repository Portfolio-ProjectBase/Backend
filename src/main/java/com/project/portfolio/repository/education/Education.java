package com.project.portfolio.repository.education;

import com.project.portfolio.core.Base;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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


}
