package com.project.portfolio.service.resume;

import com.project.portfolio.controller.resume.request.CreateResumeRequest;
import com.project.portfolio.controller.resume.request.UpdateResumeRequest;
import com.project.portfolio.controller.resume.response.ResumeResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ResumeService {

    void saveResume(MultipartFile file) throws IOException;
    byte[] getResume() throws IOException;

}
