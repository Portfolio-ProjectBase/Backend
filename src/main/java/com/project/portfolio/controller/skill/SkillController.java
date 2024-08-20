package com.project.portfolio.controller.skill;

import com.project.portfolio.controller.BaseController;
import com.project.portfolio.controller.skill.request.CreateSkillRequest;
import com.project.portfolio.controller.skill.request.UpdateSkillRequest;
import com.project.portfolio.controller.skill.response.SkillResponse;
import com.project.portfolio.service.skill.SkillService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/skills")
@RequiredArgsConstructor
public class SkillController extends BaseController {

    private final SkillService skillService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateSkillRequest skillRequest){
        skillService.create(skillRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid UpdateSkillRequest skillRequest){
        skillService.update(skillRequest);
        return answer(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/{id}")
    public ResponseEntity<SkillResponse> getById(@PathVariable int id){
        SkillResponse response = skillService.getById(id);
        return answer(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<SkillResponse>> getAll(){
        List<SkillResponse> responses = skillService.getAll();
        return answer(responses, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        skillService.delete(id);
        return answer(HttpStatus.NO_CONTENT);
    }

}
