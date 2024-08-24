package com.project.portfolio.controller.language;

import com.project.portfolio.controller.BaseController;
import com.project.portfolio.controller.language.language.request.CreateLanguageRequest;
import com.project.portfolio.controller.language.language.request.UpdateLanguageRequest;
import com.project.portfolio.controller.language.language.response.LanguageResponse;
import com.project.portfolio.service.language.language.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/language")
public class LanguageController extends BaseController {
    private final LanguageService service;
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateLanguageRequest request) {
        service.create(request);
        return answer(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody UpdateLanguageRequest request){
        service.update(request);
        return answer(HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<LanguageResponse>> getAll() {
        List<LanguageResponse> responses = service.getAll();
        return answer(responses, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<LanguageResponse> getById(@PathVariable int id) {
        LanguageResponse response = service.getById(id);
        return answer(response, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        service.delete(id);
        return answer(HttpStatus.NO_CONTENT);
    }
}
