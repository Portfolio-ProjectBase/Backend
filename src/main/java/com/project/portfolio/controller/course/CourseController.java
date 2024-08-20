package com.project.portfolio.controller.course;

import com.project.portfolio.controller.BaseController;
import com.project.portfolio.controller.course.request.CreateCourseRequest;
import com.project.portfolio.controller.course.request.UpdateCourseRequest;
import com.project.portfolio.controller.course.response.CourseResponse;
import com.project.portfolio.service.course.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/courses")
@RequiredArgsConstructor
public class CourseController extends BaseController {

    private final CourseService courseService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateCourseRequest createCourseRequest){
        courseService.create(createCourseRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid UpdateCourseRequest updateCourseRequest){
        courseService.update(updateCourseRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> getById(@PathVariable int id){
        CourseResponse response = courseService.getById(id);
        return answer(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CourseResponse>> getAll(){
        List<CourseResponse> responses = courseService.getAll();
        return answer(responses, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        courseService.delete(id);
        return answer(HttpStatus.NO_CONTENT);
    }
}
