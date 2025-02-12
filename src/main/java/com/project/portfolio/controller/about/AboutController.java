package com.project.portfolio.controller.about;

import com.project.portfolio.controller.BaseController;
import com.project.portfolio.controller.about.request.CreateAboutRequest;
import com.project.portfolio.controller.about.request.UpdateAboutRequest;
import com.project.portfolio.controller.about.response.AboutResponse;
import com.project.portfolio.service.about.AboutService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/about")
@RequiredArgsConstructor
public class AboutController extends BaseController {
    private final AboutService aboutService;

    /**
     * Yeni About kaydı oluşturur.
     */
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody CreateAboutRequest request) {
        aboutService.create(request);
        return answer(HttpStatus.NO_CONTENT);
    }

    /**
     * Varolan bir About kaydını günceller.
     */
    @PutMapping
    public ResponseEntity<Void> update(@Valid @RequestBody UpdateAboutRequest request) {
        aboutService.update(request);
        return ResponseEntity.ok().build();
    }

    /**
     * ID'ye göre tek bir About kaydını getirir.
     */
    @GetMapping("/{id}")
    public ResponseEntity<AboutResponse> getById(@PathVariable int id) {
        AboutResponse response = aboutService.getById(id);
        return answer(response, HttpStatus.OK);
    }

    /**
     * Tüm About kayıtlarını getirir (Sayfalama desteği ile).
     */
    @GetMapping
    public ResponseEntity<List<AboutResponse>> getAll(){
        List<AboutResponse> responses = aboutService.getAll();
        return answer(responses, HttpStatus.OK);
    }
    /**
     * ID'ye göre bir About kaydını siler.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        aboutService.delete(id);
        return answer(HttpStatus.NO_CONTENT);
    }
}
