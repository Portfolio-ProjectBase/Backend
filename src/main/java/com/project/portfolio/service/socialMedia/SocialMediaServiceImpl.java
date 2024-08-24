package com.project.portfolio.service.socialMedia;

import com.project.portfolio.controller.socialMedia.request.CreateSocialMediaRequest;
import com.project.portfolio.controller.socialMedia.request.UpdateSocialMediaRequest;
import com.project.portfolio.controller.socialMedia.response.SocialMediaResponse;
import com.project.portfolio.repository.socialMedia.SocialMedia;
import com.project.portfolio.repository.socialMedia.SocialMediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SocialMediaServiceImpl implements SocialMediaService{

    private final SocialMediaRepository socialMediaRepository;

    @Override
    public void create(CreateSocialMediaRequest createSocialMediaRequest) {
       socialMediaRepository.save(toEntity(createSocialMediaRequest));
    }

    @Override
    public void update(UpdateSocialMediaRequest updateSocialMediaRequest) {
        getById(updateSocialMediaRequest.getId());
        socialMediaRepository.save(toEntity(updateSocialMediaRequest));
    }

    @Override
    public List<SocialMediaResponse> getAll() {
        List<SocialMedia> socialMediaList = socialMediaRepository.findAll();
        return socialMediaList.stream().map(SocialMedia::toResponse).toList();
    }

    @Override
    public SocialMediaResponse getById(int id) {
        return socialMediaRepository.findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException("Social Media not found with id: " + id))
                .toResponse();
    }

    @Override
    public void delete(int id) {
       socialMediaRepository.deleteById(id);
    }

    public SocialMedia toEntity(CreateSocialMediaRequest createSocialMediaRequest){
        return SocialMedia.builder()
                .name(createSocialMediaRequest.getName())
                .link(createSocialMediaRequest.getLink())
                .image(createSocialMediaRequest.getImage())
                .build();
    }

    public SocialMedia toEntity(UpdateSocialMediaRequest updateSocialMediaRequest){
        return SocialMedia.builder()
                .id(updateSocialMediaRequest.getId())
                .name(updateSocialMediaRequest.getName())
                .link(updateSocialMediaRequest.getLink())
                .image(updateSocialMediaRequest.getImage())
                .build();
    }
}
