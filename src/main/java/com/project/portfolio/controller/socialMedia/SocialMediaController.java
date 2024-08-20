package com.project.portfolio.controller.socialMedia;

import com.project.portfolio.controller.BaseController;
import com.project.portfolio.controller.socialMedia.request.CreateSocialMediaRequest;
import com.project.portfolio.controller.socialMedia.request.UpdateSocialMediaRequest;
import com.project.portfolio.controller.socialMedia.response.SocialMediaResponse;
import com.project.portfolio.service.socialMedia.SocialMediaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/socialMedias")
@RequiredArgsConstructor
public class SocialMediaController extends BaseController {

    private final SocialMediaService service;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateSocialMediaRequest socialMediaRequest){

        service.create(socialMediaRequest);
        return answer(HttpStatus.NO_CONTENT);

    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody UpdateSocialMediaRequest socialMediaRequest){

        service.update(socialMediaRequest);
        return answer(HttpStatus.NO_CONTENT);

    }

    @GetMapping("/{id}")
    public ResponseEntity<SocialMediaResponse> getById(@PathVariable int id){

        SocialMediaResponse response = service.getById(id);
        return answer(response, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<SocialMediaResponse>> getAll(){

        List<SocialMediaResponse> responses = service.getAll();
        return answer(responses, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){

        service.delete(id);
        return answer(HttpStatus.NO_CONTENT);

    }

}
