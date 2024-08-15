package com.project.portfolio.service.language.languageLevel;

import com.project.portfolio.controller.language.languageLevel.request.CreateLanguageLevelRequest;
import com.project.portfolio.controller.language.languageLevel.request.UpdateLanguageLevelRequest;
import com.project.portfolio.controller.language.languageLevel.response.LanguageLevelResponse;

import java.util.List;

public interface LanguageLevelService {
    void create(CreateLanguageLevelRequest createLanguageLevelRequest);
    void update(UpdateLanguageLevelRequest updateLanguageLevelRequest);
    List<LanguageLevelResponse> getAll();
    LanguageLevelResponse getById(int id);
    void delete(int id);
}
