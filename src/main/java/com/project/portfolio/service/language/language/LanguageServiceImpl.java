package com.project.portfolio.service.language.language;

import com.project.portfolio.controller.language.language.request.CreateLanguageRequest;
import com.project.portfolio.controller.language.language.request.UpdateLanguageRequest;
import com.project.portfolio.controller.language.language.response.LanguageResponse;
import com.project.portfolio.repository.language.Language;
import com.project.portfolio.repository.language.LanguageLevel;
import com.project.portfolio.repository.language.LanguageRepository;
import com.project.portfolio.repository.user.User;
import com.project.portfolio.service.language.languageLevel.LanguageLevelService;
import com.project.portfolio.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;
    private final LanguageLevelService languageLevelService;
    private final UserService userService;
    @Override
    public void create(CreateLanguageRequest createLanguageRequest) {
       languageRepository.save(toEntity(createLanguageRequest));
    }

    @Override
    public void update(UpdateLanguageRequest updateLanguageRequest) {
       languageRepository.save(toEntity(updateLanguageRequest));
    }

    @Override
    public List<LanguageResponse> getAll() {
        List<Language> languages = languageRepository.findAll();
        return languages.stream().map(Language::toResponse).toList();
    }

    @Override
    public LanguageResponse getById(int id) {

        return languageRepository.findById(id).orElseThrow().toResponse();
    }

    @Override
    public void delete(int id) {
        languageRepository.deleteById(id);
    }

    public Language toEntity(CreateLanguageRequest createLanguageRequest){
        return Language.builder()
                .name(createLanguageRequest.getName())
                .languageLevel(LanguageLevel.fromResponse(languageLevelService.getById(createLanguageRequest.getLevelId())))
                .user(User.fromResponse(userService.getById(createLanguageRequest.getUserId())))
                .build();
    }

    public Language toEntity(UpdateLanguageRequest updateLanguageRequest){
        return Language.builder()
                .id(updateLanguageRequest.getId())
                .name(updateLanguageRequest.getName())
                .languageLevel(LanguageLevel.fromResponse(languageLevelService.getById(updateLanguageRequest.getLevelId())))
                .user(User.fromResponse(userService.getById(updateLanguageRequest.getUserId())))
                .build();
    }


}
