package com.project.portfolio.service.language.language;

import com.project.portfolio.controller.language.language.request.CreateLanguageRequest;
import com.project.portfolio.controller.language.language.request.UpdateLanguageRequest;
import com.project.portfolio.controller.language.language.response.LanguageResponse;

import java.util.List;

public interface LanguageService {
    void create(CreateLanguageRequest createLanguageRequest);
    void update(UpdateLanguageRequest updateLanguageRequest);
    List<LanguageResponse> getAll();
    LanguageResponse getById(int id);
    void delete(int id);
}
