package com.project.portfolio.service.about;

import com.project.portfolio.controller.about.request.CreateAboutRequest;
import com.project.portfolio.controller.about.request.UpdateAboutRequest;
import com.project.portfolio.controller.about.response.AboutResponse;
import com.project.portfolio.repository.about.About;
import com.project.portfolio.repository.about.AboutRepository;
import com.project.portfolio.repository.card.Card;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AboutServiceImpl implements AboutService{
    private final AboutRepository aboutRepository;

    @Override
    public void create(CreateAboutRequest aboutRequest) {
        About about = toEntity(aboutRequest);
        about.getCards().forEach(card -> card.setAbout(about));
        aboutRepository.save(about);
    }

    @Override
    public void update(UpdateAboutRequest aboutRequest) {
        About about = toEntity(aboutRequest);
        about.getCards().forEach(card -> card.setAbout(about)); // 🔹 Ensure each Card has an About reference
        aboutRepository.save(about);
    }
    @Transactional
    @Override
    public List<AboutResponse> getAll() {
        return aboutRepository.findAll()
                .stream()
                .map(About::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AboutResponse getById(int id) {
        return aboutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("About not found!"))
                .toResponse();
    }

    @Override
    public void delete(int id) {
        aboutRepository.deleteById(id);
    }


    public About toEntity(CreateAboutRequest aboutRequest) {
        return About.builder()
                .aboutText(aboutRequest.getAboutText())
                .cards(aboutRequest.getCards()
                        .stream()
                        .map(cardRequest -> Card.builder()
                                .title(cardRequest.getTitle())
                                .description(cardRequest.getDescription())
                                .build()
                        )
                        .collect(Collectors.toList()))
                .build();
    }

    public About toEntity(UpdateAboutRequest aboutRequest) {
        return About.builder()
                .id(aboutRequest.getId())
                .aboutText(aboutRequest.getAboutText())
                .cards(aboutRequest.getCards()
                        .stream()
                        .map(cardRequest -> Card.builder()
                                .id(cardRequest.getId())
                                .title(cardRequest.getTitle())
                                .description(cardRequest.getDescription())
                                .build()
                        )
                        .collect(Collectors.toList()))
                .build();
    }
}
