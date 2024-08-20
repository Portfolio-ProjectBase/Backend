package com.project.portfolio.controller.experience;

import com.project.portfolio.controller.BaseController;
import com.project.portfolio.controller.experience.request.CreateExperienceRequest;
import com.project.portfolio.controller.experience.request.UpdateExperienceRequest;
import com.project.portfolio.controller.experience.response.ExperienceResponse;
import com.project.portfolio.service.experience.ExperienceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/experiences")
@RequiredArgsConstructor
public class ExperienceController extends BaseController {

    private final ExperienceService experienceService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateExperienceRequest createExperienceRequest){
        experienceService.create(createExperienceRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> update(UpdateExperienceRequest updateExperienceRequest){
        experienceService.update(updateExperienceRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExperienceResponse> getById(@PathVariable int id){
        ExperienceResponse response = experienceService.getById(id);
        return answer(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ExperienceResponse>> getAll(){
        List<ExperienceResponse> responses = experienceService.getAll();
        return answer(responses, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        experienceService.delete(id);
        return answer(HttpStatus.NO_CONTENT);
    }
}
