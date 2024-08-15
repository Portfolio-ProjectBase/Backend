package com.project.portfolio.repository.course;

import com.project.portfolio.controller.course.response.CourseResponse;
import com.project.portfolio.core.Base;
import com.project.portfolio.repository.language.LanguageLevel;
import com.project.portfolio.repository.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public CourseResponse toResponse() {
        return new CourseResponse(name, instructor, detail, date);
    }
}
