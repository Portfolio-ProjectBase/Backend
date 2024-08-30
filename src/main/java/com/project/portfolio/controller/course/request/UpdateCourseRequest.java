package com.project.portfolio.controller.course.request;

import com.project.portfolio.repository.course.Course;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateCourseRequest {
    @NotNull
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String instructor;
    @Size(min = 2, max = 500, message = "Mesaj için en az 2, en fazla 500 karakter giriniz.")
    private String detail;
    @NotBlank
    private Date date;

}
