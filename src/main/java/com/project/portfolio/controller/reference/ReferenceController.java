package com.project.portfolio.controller.reference;

import com.project.portfolio.controller.BaseController;
import com.project.portfolio.controller.reference.request.CreateReferenceRequest;
import com.project.portfolio.controller.reference.request.UpdateReferenceRequest;
import com.project.portfolio.controller.reference.response.ReferenceResponse;
import com.project.portfolio.service.reference.ReferenceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/references")
@RequiredArgsConstructor
public class ReferenceController extends BaseController {

    private final ReferenceService referenceService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateReferenceRequest createReferenceRequest){
        referenceService.create(createReferenceRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid UpdateReferenceRequest updateReferenceRequest){
        referenceService.update(updateReferenceRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReferenceResponse> getById(@PathVariable int id){
        ReferenceResponse response = referenceService.getById(id);
        return answer(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ReferenceResponse>> getAll(){
        List<ReferenceResponse> responses = referenceService.getAll();
        return answer(responses, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        referenceService.delete(id);
        return answer(HttpStatus.NO_CONTENT);
    }
}
