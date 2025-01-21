package com.project.portfolio.service.resume;

import com.project.portfolio.controller.resume.request.CreateResumeRequest;
import com.project.portfolio.controller.resume.request.UpdateResumeRequest;
import com.project.portfolio.controller.resume.response.ResumeResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ResumeService {

    void saveResume(MultipartFile file);
    byte[] getResume() throws IOException;
    boolean checkResumeExists();
    Map<String, String> getResumeInfo();
}
