package com.project.portfolio.service.course;

import com.project.portfolio.controller.course.request.CreateCourseRequest;
import com.project.portfolio.controller.course.request.UpdateCourseRequest;
import com.project.portfolio.controller.course.response.CourseResponse;
import com.project.portfolio.controller.project.response.PagedResponse;

import java.util.List;

public interface CourseService {

    void create(CreateCourseRequest courseRequest);
    void update(UpdateCourseRequest courseRequest);
    PagedResponse<CourseResponse> getAll(int page, int size);
    CourseResponse getById(int id);
    void delete(int id);

}
