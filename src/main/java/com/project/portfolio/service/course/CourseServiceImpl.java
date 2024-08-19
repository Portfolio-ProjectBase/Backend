package com.project.portfolio.service.course;

import com.project.portfolio.controller.course.request.CreateCourseRequest;
import com.project.portfolio.controller.course.request.UpdateCourseRequest;
import com.project.portfolio.controller.course.response.CourseResponse;
import com.project.portfolio.repository.course.Course;
import com.project.portfolio.repository.course.CourseRepository;
import com.project.portfolio.repository.user.User;
import com.project.portfolio.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseRepository repository;
    private final UserService userService;

    public CourseResponse getById(int id) {
        Course course = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + id));
        return course.toResponse();
    }

    public void create(CreateCourseRequest createCourseRequest) {

        repository.save(toEntity(createCourseRequest));

    }

    public void update(UpdateCourseRequest updateCourseRequest) {

        Course course = repository.findById(updateCourseRequest.getId())
                .orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + updateCourseRequest.getId()));
        course.setName(updateCourseRequest.getName());
        course.setInstructor(updateCourseRequest.getInstructor());
        course.setDetail(updateCourseRequest.getDetail());
        course.setDate(updateCourseRequest.getDate());
        repository.save(course);

    }

    @Override
    public List<CourseResponse> getAll() {

        List<Course> courses = repository.findAll();
        List<CourseResponse> responses = courses.stream().map(Course::toResponse).toList();
        return responses;

    }

    public void delete(int id) {
        repository.deleteById(id);
    }

    public Course toEntity(CreateCourseRequest courseRequest){
        return Course.builder()
                .name(courseRequest.getName())
                .instructor(courseRequest.getInstructor())
                .detail(courseRequest.getDetail())
                .date(courseRequest.getDate())
                .build();
    }

    public Course toEntity(UpdateCourseRequest courseRequest){
        return Course.builder()
                .id(courseRequest.getId())
                .name(courseRequest.getName())
                .instructor(courseRequest.getInstructor())
                .detail(courseRequest.getDetail())
                .date(courseRequest.getDate())
                .build();
    }
}
