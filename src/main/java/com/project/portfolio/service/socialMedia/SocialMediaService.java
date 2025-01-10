package com.project.portfolio.service.socialMedia;

import com.project.portfolio.controller.project.response.PagedResponse;
import com.project.portfolio.controller.socialMedia.request.CreateSocialMediaRequest;
import com.project.portfolio.controller.socialMedia.request.UpdateSocialMediaRequest;
import com.project.portfolio.controller.socialMedia.response.SocialMediaResponse;

import java.util.List;

public interface SocialMediaService {
    void create(CreateSocialMediaRequest createSocialMediaRequest);
    void update(UpdateSocialMediaRequest updateSocialMediaRequest);
    PagedResponse<SocialMediaResponse> getAll(int page, int size);
    SocialMediaResponse getById(int id);
    void delete(int id);

}
