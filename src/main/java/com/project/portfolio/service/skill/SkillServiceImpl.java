package com.project.portfolio.service.skill;

import com.project.portfolio.controller.skill.request.CreateSkillRequest;
import com.project.portfolio.controller.skill.request.UpdateSkillRequest;
import com.project.portfolio.controller.skill.response.SkillResponse;
import com.project.portfolio.repository.post.Post;
import com.project.portfolio.repository.project.Project;
import com.project.portfolio.repository.skill.Skill;
import com.project.portfolio.repository.skill.SkillRepository;
import com.project.portfolio.repository.user.User;
import com.project.portfolio.service.post.PostService;
import com.project.portfolio.service.project.ProjectService;
import com.project.portfolio.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillServiceImpl implements SkillService{

    private final SkillRepository skillRepository;
    private final UserService userService;
    private final ProjectService projectService;
    private final PostService postService;

    @Override
    public void create(CreateSkillRequest createSkillRequest) {
        skillRepository.save(toEntity(createSkillRequest));

    }

    @Override
    public void update(UpdateSkillRequest updateSkillRequest) {
        skillRepository.save(toEntity(updateSkillRequest));

    }

    @Override
    public List<SkillResponse> getAll() {
        List<Skill> skills = skillRepository.findAll();
        return skills.stream().map(Skill::toResponse).toList();
    }

    @Override
    public SkillResponse getById(int id) {
        return skillRepository.findById(id).orElseThrow().toResponse();
    }

    @Override
    public void delete(int id) {
        skillRepository.deleteById(id);

    }

    public Skill toEntity(CreateSkillRequest createSkillRequest){
        return Skill.builder()
                .name(createSkillRequest.getName())
                .project(Project.fromResponse(projectService.getById(createSkillRequest.getProjectId())))
                .post(Post.fromResponse(postService.getById(createSkillRequest.getPostId())))
                .user(User.fromResponse(userService.getById(createSkillRequest.getUserId())))
                .build();
    }

    public Skill toEntity(UpdateSkillRequest updateSkillRequest){
        return Skill.builder()
                .id(updateSkillRequest.getId())
                .name(updateSkillRequest.getName())
                .project(Project.fromResponse(projectService.getById(updateSkillRequest.getProjectId())))
                .post(Post.fromResponse(postService.getById(updateSkillRequest.getPostId())))
                .user(User.fromResponse(userService.getById(updateSkillRequest.getUserId())))
                .build();
    }


}
