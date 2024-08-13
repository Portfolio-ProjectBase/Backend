package com.project.portfolio.controller.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
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
}
