package com.project.portfolio.service.resume;

import com.project.portfolio.core.exception.DataNotFoundException;
import com.project.portfolio.core.exception.FileException;
import com.project.portfolio.repository.resume.Resume;
import com.project.portfolio.repository.resume.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static com.project.portfolio.core.exception.type.FileExceptionType.RESUME_FILE_ERROR;
import static com.project.portfolio.core.exception.type.NotFoundExceptionType.RESUME_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRepository resumeRepository;
    private final ResumeRules resumeRules;

    public void saveResume(MultipartFile file) {

        resumeRules.validateResumeFile(file);

        try {
            Resume resume = Resume.builder()
                    .name(file.getOriginalFilename())
                    .fileType(file.getContentType())
                    .fileData(file.getBytes()) // PDF dosyasını byte array olarak alıyoruz
                    .build();
            resumeRepository.save(resume); // Veritabanına kaydediyoruz
        } catch (IOException e) {
            throw new FileException(RESUME_FILE_ERROR);
        }
    }

    @Override
    public byte[] getResume() throws IOException {
        // Veritabanında sadece tek bir kayıt olduğundan ilkini döndürüyoruz
        Resume resume = resumeRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new DataNotFoundException(RESUME_NOT_FOUND));
        return resume.getFileData(); // PDF dosyasının byte array'ini döndürüyoruz
    }
}
