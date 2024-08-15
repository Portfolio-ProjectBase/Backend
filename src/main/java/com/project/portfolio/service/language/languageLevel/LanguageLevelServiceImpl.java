package com.project.portfolio.service.language.languageLevel;

import com.project.portfolio.controller.language.languageLevel.request.CreateLanguageLevelRequest;
import com.project.portfolio.controller.language.languageLevel.request.UpdateLanguageLevelRequest;
import com.project.portfolio.controller.language.languageLevel.response.LanguageLevelResponse;
import com.project.portfolio.repository.language.LanguageLevel;
import com.project.portfolio.repository.language.LanguageLevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageLevelServiceImpl implements LanguageLevelService{

    private final LanguageLevelRepository languageLevelRepository;

    @Override
    public void create(CreateLanguageLevelRequest createLanguageLevelRequest) {
         languageLevelRepository.save(toEntity(createLanguageLevelRequest));
    }

    @Override
    public void update(UpdateLanguageLevelRequest updateLanguageLevelRequest) {
         languageLevelRepository.save(toEntity(updateLanguageLevelRequest));
    }

    @Override
    public List<LanguageLevelResponse> getAll() {
        List<LanguageLevel> languageLevelList = languageLevelRepository.findAll();
        return languageLevelList.stream().map(LanguageLevel::toResponse).toList();
    }

    @Override
    public LanguageLevelResponse getById(int id) {
        return languageLevelRepository.findById(id).orElseThrow().toResponse();
    }

    @Override
    public void delete(int id) {
        languageLevelRepository.deleteById(id);

    }

    public LanguageLevel toEntity(CreateLanguageLevelRequest createLanguageLevelRequest){
        return LanguageLevel.builder()
                .name(createLanguageLevelRequest.getName())
                .level(createLanguageLevelRequest.getLevel())
                .build();
    }

    public LanguageLevel toEntity(UpdateLanguageLevelRequest updateLanguageLevelRequest){
        return LanguageLevel.builder()
                .id(updateLanguageLevelRequest.getId())
                .name(updateLanguageLevelRequest.getName())
                .level(updateLanguageLevelRequest.getLevel())
                .build();
    }
}
