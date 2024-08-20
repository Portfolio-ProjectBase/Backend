package com.project.portfolio.controller.user;

import com.project.portfolio.controller.BaseController;
import com.project.portfolio.controller.user.request.UpdateUserRequest;
import com.project.portfolio.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController extends BaseController {

    private final UserService userService;

    @PostMapping("/uploadResume")
    public ResponseEntity<String> uploadResume(@RequestParam("file") MultipartFile file) {
        try {
            // Dosyayı saklayacağın dizin
            String uploadDir = "/uploads/resumes/";
            String fileName = UUID.randomUUID().toString() + "-" + file.getOriginalFilename();
            Path filePath = Paths.get(uploadDir + fileName);

            // Dosyayı dizine kaydet
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, file.getBytes());

            // URL'yi oluştur
            String resumeUrl = "/uploads/resumes/" + fileName;

            // URL'yi veri tabanında kaydet
            // user.setResumeUrl(resumeUrl);
            // userRepository.save(user);

            return ResponseEntity.ok(resumeUrl);

        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Dosya yüklenirken bir hata oluştu.");
        }
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody UpdateUserRequest userRequest){

        userService.update(userRequest);
        return answer(HttpStatus.NO_CONTENT);

    }
}
