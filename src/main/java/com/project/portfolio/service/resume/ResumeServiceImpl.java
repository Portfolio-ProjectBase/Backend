package com.project.portfolio.service.resume;

import com.project.portfolio.controller.resume.request.CreateResumeRequest;
import com.project.portfolio.controller.resume.request.UpdateResumeRequest;
import com.project.portfolio.controller.resume.response.ResumeResponse;
import com.project.portfolio.repository.resume.Resume;
import com.project.portfolio.repository.resume.ResumeRepository;
import com.project.portfolio.repository.user.User;
import com.project.portfolio.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService{

    private final ResumeRepository resumeRepository;
    private final UserService userService;

    @Override
    public void create(CreateResumeRequest resumeRequest) {

        resumeRepository.save(toEntity(resumeRequest));

    }

    @Override
    public void update(UpdateResumeRequest resumeRequest) {

        resumeRepository.save(toEntity(resumeRequest));

    }

    @Override
    public List<ResumeResponse> getAll() {

        List<Resume> resumes = resumeRepository.findAll();
        return resumes.stream().map(Resume::toResponse).toList();

    }

    @Override
    public ResumeResponse getById(int id) {

        return resumeRepository.findById(id).orElseThrow().toResponse();

    }


    @Override
    public void delete(int id) {

        resumeRepository.deleteById(id);

    }

    public Resume toEntity(CreateResumeRequest resumeRequest){
        return Resume.builder()
                .name(resumeRequest.getName())
                .fileUrl(resumeRequest.getFileUrl())
                .fileType(resumeRequest.getFileType())
                .user(User.fromResponse(userService.getById(resumeRequest.getUserId())))
                .build();
    }

    public Resume toEntity(UpdateResumeRequest resumeRequest){
        return Resume.builder()
                .id(resumeRequest.getId())
                .name(resumeRequest.getName())
                .fileUrl(resumeRequest.getFileUrl())
                .fileType(resumeRequest.getFileType())
                .user(User.fromResponse(userService.getById(resumeRequest.getUserId())))
                .build();
    }

}
