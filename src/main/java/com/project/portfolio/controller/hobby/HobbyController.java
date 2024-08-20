package com.project.portfolio.controller.hobby;

import com.project.portfolio.controller.BaseController;
import com.project.portfolio.controller.hobby.request.CreateHobbyRequest;
import com.project.portfolio.controller.hobby.request.UpdateHobbyRequest;
import com.project.portfolio.controller.hobby.response.HobbyResponse;
import com.project.portfolio.service.hobby.HobbyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/hobbies")
@RequiredArgsConstructor
public class HobbyController extends BaseController {

    private final HobbyService hobbyService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateHobbyRequest hobbyRequest){

        hobbyService.create(hobbyRequest);
        return answer(HttpStatus.NO_CONTENT);

    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody UpdateHobbyRequest hobbyRequest){

        hobbyService.update(hobbyRequest);
        return answer(HttpStatus.NO_CONTENT);

    }

    @GetMapping("/{id}")
    public ResponseEntity<HobbyResponse> getById(@PathVariable int id){

        HobbyResponse response = hobbyService.getById(id);
        return answer(response, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<HobbyResponse>> getAll(){

        List<HobbyResponse> responses = hobbyService.getAll();
        return answer(responses, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){

        hobbyService.delete(id);
        return answer(HttpStatus.NO_CONTENT);

    }

}
