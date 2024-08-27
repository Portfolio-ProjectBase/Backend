package com.project.portfolio.service.resume;

import com.project.portfolio.core.exception.FileException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import static com.project.portfolio.core.exception.type.FileExceptionType.RESUME_FILE_ERROR;

@Service
@RequiredArgsConstructor
public class ResumeRules {

    public void validateResumeFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new FileException(RESUME_FILE_ERROR, "Dosya boş olamaz.");
        }

        if (file.getSize() > 10485760) { // Örneğin, 10MB'tan büyük dosyaları kabul etmiyoruz
            throw new FileException(RESUME_FILE_ERROR, "Dosya boyutu 10MB'tan büyük olamaz.");
        }

        if (!"application/pdf".equals(file.getContentType())) { // Sadece PDF dosyalarına izin veriyoruz
            throw new FileException(RESUME_FILE_ERROR, "Sadece PDF dosyalarına izin verilmektedir.");
        }
    }
}

