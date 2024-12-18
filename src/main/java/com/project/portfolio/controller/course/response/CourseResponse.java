package com.project.portfolio.controller.course.response;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CourseResponse {
    private int id;
    private String name;
    private String instructor;
    private String detail;
    private LocalDate date;
}
