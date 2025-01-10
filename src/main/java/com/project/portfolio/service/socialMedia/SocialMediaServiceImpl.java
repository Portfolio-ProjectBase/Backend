package com.project.portfolio.service.socialMedia;

import com.project.portfolio.controller.project.response.PagedResponse;
import com.project.portfolio.controller.socialMedia.request.CreateSocialMediaRequest;
import com.project.portfolio.controller.socialMedia.request.UpdateSocialMediaRequest;
import com.project.portfolio.controller.socialMedia.response.SocialMediaResponse;
import com.project.portfolio.core.exception.DataNotFoundException;
import com.project.portfolio.core.exception.type.NotFoundExceptionType;
import com.project.portfolio.repository.socialMedia.SocialMedia;
import com.project.portfolio.repository.socialMedia.SocialMediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        SocialMedia existingSocialMedia = socialMediaRepository.findById(updateSocialMediaRequest.getId())
                .orElseThrow(() -> new DataNotFoundException(NotFoundExceptionType.SOCIAL_MEDIA_NOT_FOUND));
        if (updateSocialMediaRequest.getIsGetNewPicture() && updateSocialMediaRequest.getImage() != null) {
            existingSocialMedia.setImage(updateSocialMediaRequest.getImage());
        }
        SocialMedia updatedSocialMedia = toEntity(updateSocialMediaRequest);
        updatedSocialMedia.setId(existingSocialMedia.getId());
        if (!updateSocialMediaRequest.getIsGetNewPicture()) {
            updatedSocialMedia.setImage(existingSocialMedia.getImage());
        }
        socialMediaRepository.save(updatedSocialMedia);
    }

    @Override
    public PagedResponse<SocialMediaResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<SocialMedia> socialMediaPage = socialMediaRepository.findAll(pageable);
        List<SocialMediaResponse> socialMediaResponses = socialMediaPage
                .getContent()
                .stream()
                .map(SocialMedia::toResponse)
                .toList();
        // Sayfalama bilgilerini ekle
        return new PagedResponse<>(
                socialMediaResponses,
                socialMediaPage.getNumber(),        // Mevcut sayfa numarası
                socialMediaPage.getSize(),          // Sayfa boyutu
                socialMediaPage.getTotalPages(),    // Toplam sayfa sayısı
                socialMediaPage.getTotalElements(), // Toplam eleman sayısı
                socialMediaPage.isLast()            // Son sayfa kontrolü
        );
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
                .image(updateSocialMediaRequest.getIsGetNewPicture() ? updateSocialMediaRequest.getImage() : null)
                .isGetNewPicture(updateSocialMediaRequest.getIsGetNewPicture())
                .build();
    }
}
