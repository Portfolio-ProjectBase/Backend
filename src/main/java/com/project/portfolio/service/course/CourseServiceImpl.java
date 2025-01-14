package com.project.portfolio.service.course;

import com.project.portfolio.controller.course.request.CreateCourseRequest;
import com.project.portfolio.controller.course.request.UpdateCourseRequest;
import com.project.portfolio.controller.course.response.CourseResponse;
import com.project.portfolio.controller.project.response.PagedResponse;
import com.project.portfolio.repository.course.Course;
import com.project.portfolio.repository.course.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    private final CourseRepository repository;

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
    public PagedResponse<CourseResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Course> coursesPage = repository.findAll(pageable);
        // Listeyi dönüştür
        List<CourseResponse> courseResponses = coursesPage
                .getContent()
                .stream()
                .map(Course::toResponse)
                .toList();
        // Sayfalama bilgilerini ekle
        return new PagedResponse<>(
                courseResponses,
                coursesPage.getNumber(),        // Mevcut sayfa numarası
                coursesPage.getSize(),          // Sayfa boyutu
                coursesPage.getTotalPages(),    // Toplam sayfa sayısı
                coursesPage.getTotalElements(), // Toplam eleman sayısı
                coursesPage.isLast()            // Son sayfa kontrolü
        );
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
