package com.project.portfolio.controller.course.request;

import com.project.portfolio.repository.course.Course;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCourseRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String instructor;

    private String detail;
    @NotBlank
    private Date date;

    public Course toEntity() {
        return new Course(name, instructor, detail, date);
    }
}
