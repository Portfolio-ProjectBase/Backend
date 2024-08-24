package com.project.portfolio.service.resume;

import com.project.portfolio.controller.resume.request.CreateResumeRequest;
import com.project.portfolio.controller.resume.request.UpdateResumeRequest;
import com.project.portfolio.controller.resume.response.ResumeResponse;
import com.project.portfolio.repository.resume.Resume;
import com.project.portfolio.repository.resume.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRepository resumeRepository;

    public void saveResume(MultipartFile file) throws IOException {
        Resume resume = Resume.builder()
                .name(file.getOriginalFilename())
                .fileType(file.getContentType())
                .fileData(file.getBytes()) // PDF dosyasını byte array olarak alıyoruz
                .build();

        resumeRepository.save(resume); // Veritabanına kaydediyoruz
    }
    @Override
    public byte[] getResume() throws IOException {
        // Veritabanında sadece tek bir kayıt olduğundan ilkini döndürüyoruz
        Resume resume = resumeRepository.findAll().stream().findFirst()
                .orElseThrow(() -> new IOException("Resume not found"));
        return resume.getFileData(); // PDF dosyasının byte array'ini döndürüyoruz
    }
}
