package com.project.portfolio.service.socialMedia;

import com.project.portfolio.controller.socialMedia.request.CreateSocialMediaRequest;
import com.project.portfolio.controller.socialMedia.request.UpdateSocialMediaRequest;
import com.project.portfolio.controller.socialMedia.response.SocialMediaResponse;

import java.util.List;

public interface SocialMediaService {
    void create(CreateSocialMediaRequest createSocialMediaRequest);
    void update(UpdateSocialMediaRequest updateSocialMediaRequest);
    List<SocialMediaResponse> getAll();
    SocialMediaResponse getById(int id);
    void delete(int id);

}
