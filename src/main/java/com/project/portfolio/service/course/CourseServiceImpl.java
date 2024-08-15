package com.project.portfolio.service.course;

import com.project.portfolio.controller.course.request.CreateCourseRequest;
import com.project.portfolio.controller.course.request.UpdateCourseRequest;
import com.project.portfolio.controller.course.response.CourseResponse;
import com.project.portfolio.repository.course.Course;
import com.project.portfolio.repository.course.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseServiceImpl {
private final CourseRepository repository;

    public CourseResponse get(int id) {
        Course course = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + id));
        return course.toResponse();
    }

    public void create(CreateCourseRequest createCourseRequest) {

    }

    public CourseResponse update(UpdateCourseRequest updateCourseRequest) {
        Course course = repository.findById(updateCourseRequest.getId())
                .orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + updateCourseRequest.getId()));
        course.setName(updateCourseRequest.getName());
        course.setInstructor(updateCourseRequest.getInstructor());
        course.setDetail(updateCourseRequest.getDetail());
        course.setDate(updateCourseRequest.getDate());
        repository.save(course);

        return course.toResponse();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
