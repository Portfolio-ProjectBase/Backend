package com.project.portfolio.controller.resume;
import com.project.portfolio.service.resume.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import java.io.IOException;

@RestController
@RequestMapping("/api/resumes")
@RequiredArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;
    //@PostMapping(value = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @RequestMapping(value = "/upload", consumes = {"multipart/form-data"}, method = RequestMethod.POST)
    public String uploadResume(@RequestPart(value = "documents", required = true) MultipartFile file ){

            resumeService.saveResume(file);
            return "Dosya yükleme başarılı!";

    }

    @GetMapping("/download")
    public ResponseEntity<Resource> downloadResume() {
        try {
            byte[] fileData = resumeService.getResume();
            ByteArrayResource resource = new ByteArrayResource(fileData);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=resume.pdf")
                    .contentLength(fileData.length)
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(resource);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
