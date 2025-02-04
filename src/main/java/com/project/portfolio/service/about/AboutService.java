package com.project.portfolio.service.about;

import com.project.portfolio.controller.about.request.CreateAboutRequest;
import com.project.portfolio.controller.about.request.UpdateAboutRequest;
import com.project.portfolio.controller.about.response.AboutResponse;
import com.project.portfolio.controller.contact.response.ContactResponse;
import com.project.portfolio.repository.about.About;

import java.util.List;

public interface AboutService {
    void create(CreateAboutRequest aboutRequest);
    void update(UpdateAboutRequest aboutRequest);
    List<AboutResponse> getAll();
    AboutResponse getById(int id);
    void delete(int id);
}
