package com.project.portfolio.service.course;

import com.project.portfolio.controller.course.request.CreateCourseRequest;
import com.project.portfolio.controller.course.request.UpdateCourseRequest;
import com.project.portfolio.controller.course.response.CourseResponse;

import java.util.List;

public interface CourseService {

    void create(CreateCourseRequest courseRequest);
    void update(UpdateCourseRequest courseRequest);
    List<CourseResponse> getAll();
    CourseResponse getById(int id);
    void delete(int id);

}
