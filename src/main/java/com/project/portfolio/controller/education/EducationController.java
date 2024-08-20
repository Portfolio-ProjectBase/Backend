package com.project.portfolio.controller.education;

import com.project.portfolio.controller.BaseController;
import com.project.portfolio.controller.education.request.CreateEducationRequest;
import com.project.portfolio.controller.education.request.UpdateEducationRequest;
import com.project.portfolio.controller.education.response.EducationResponse;
import com.project.portfolio.service.education.EducationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/educations")
@RequiredArgsConstructor
public class EducationController extends BaseController {

    private final EducationService educationService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateEducationRequest createEducationRequest){
        educationService.create(createEducationRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> update(UpdateEducationRequest updateEducationRequest){
        educationService.update(updateEducationRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EducationResponse> getById(@PathVariable int id){
        EducationResponse response = educationService.getById(id);
        return answer(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EducationResponse>> getAll(){
        List<EducationResponse> responses = educationService.getAll();
        return answer(responses, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        educationService.delete(id);
        return answer(HttpStatus.NO_CONTENT);
    }
}
