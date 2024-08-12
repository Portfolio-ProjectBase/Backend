package com.project.portfolio.repository.course;

import com.project.portfolio.core.Base;
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
@Table(name = "Course")
public class Course extends Base {
    private String name;
    private String instructor;
    private String detail;
    private Date date;
}
