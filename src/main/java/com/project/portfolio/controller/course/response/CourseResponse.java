package com.project.portfolio.controller.course.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CourseResponse {
    private String name;
    private String instructor;
    private String detail;
    private Date date;
}
