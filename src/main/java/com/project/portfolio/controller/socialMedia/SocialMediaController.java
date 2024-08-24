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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/v1/socialMedias")
@RequiredArgsConstructor
public class SocialMediaController extends BaseController {

    private final SocialMediaService service;

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Void> create(@RequestParam String name,
                                       @RequestParam String link,
                                       @RequestPart(value = "image", required = false) MultipartFile image) {

        CreateSocialMediaRequest request = new CreateSocialMediaRequest();
        request.setName(name);
        request.setLink(link);
        if (image != null) {
            try {
                request.setImage(image.getBytes());
            } catch (IOException e) {
                return answer(HttpStatus.BAD_REQUEST); // Resim yükleme hatası durumunda
            }
        }
        service.create(request);
        return answer(HttpStatus.NO_CONTENT);

    }

    @PutMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Void> update(
                                        @RequestParam int id,
                                        @RequestParam String name,
                                        @RequestParam String link,
                                        @RequestPart(value = "image", required = false) MultipartFile image) {
        UpdateSocialMediaRequest request = UpdateSocialMediaRequest.builder()
                .id(id)
                .name(name)
                .link(link)
                .build();
        if (image != null) {
            try {
                request.setImage(image.getBytes());
            } catch (IOException e) {
                return answer(HttpStatus.BAD_REQUEST); // Resim yükleme hatası durumunda
            }
        }
        service.update(request);
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
