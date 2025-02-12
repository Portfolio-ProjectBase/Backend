package com.project.portfolio.service.certificate;

import com.project.portfolio.controller.certificate.request.CreateCertificateRequest;
import com.project.portfolio.controller.certificate.request.UpdateCertificateRequest;
import com.project.portfolio.controller.certificate.response.CertificateResponse;
import com.project.portfolio.controller.project.response.PagedResponse;
import com.project.portfolio.core.exception.DataNotFoundException;
import com.project.portfolio.core.exception.type.NotFoundExceptionType;
import com.project.portfolio.repository.certificate.Certificate;
import com.project.portfolio.repository.certificate.CertificateRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService{

    private final CertificateRepository certificateRepository;
    private final CertificateRule rule;

    @Override
    public void create(CreateCertificateRequest certificateRequest) {
        rule.check(rule.fix(certificateRequest));
        certificateRepository.save(toEntity(certificateRequest));

    }

    @Override
    public void update(UpdateCertificateRequest certificateRequest) {
        rule.check(rule.fix(certificateRequest));

        // Mevcut sertifikayı veri tabanından al
        Certificate existingCertificate = certificateRepository.findById(certificateRequest.getId())
                .orElseThrow(() -> new DataNotFoundException(NotFoundExceptionType.CERTIFICATE_NOT_FOUND));

        // Eğer yeni resim gönderildiyse ve `isGetNewPicture` true ise, resmi güncelle
        if (certificateRequest.getIsGetNewPicture() && certificateRequest.getImage() != null) {
            existingCertificate.setImage(certificateRequest.getImage()); // Yeni resmi ayarla
            System.out.println("New image set to existingCertificate");
        }

        // Diğer alanları güncellemek için `toEntity` metodunu kullan
        Certificate updatedCertificate = toEntity(certificateRequest);

        // `toEntity` den gelen değerleri mevcut sertifika ile birleştir
        updatedCertificate.setId(existingCertificate.getId()); // ID aynı kalmalı

        if (!certificateRequest.getIsGetNewPicture()) {
            updatedCertificate.setImage(existingCertificate.getImage()); // Yeni resim yoksa eski resmi koru
            System.out.println("Existing image preserved");
        }

        System.out.println("Final updatedCertificate Image: " + (updatedCertificate.getImage() != null ? "Image found" : "No image"));

        // Güncellenmiş nesneyi kaydet
        certificateRepository.save(updatedCertificate);
        System.out.println("Certificate saved successfully");
    }


    @Override
    public PagedResponse<CertificateResponse> getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Certificate> certificatePage = certificateRepository.findAll(pageable);
        List<CertificateResponse> certificateResponses = certificatePage
                .getContent()
                .stream()
                .map(Certificate::toResponse)
                .toList();
        // Sayfalama bilgilerini ekle
        return new PagedResponse<>(
                certificateResponses,
                certificatePage.getNumber(),        // Mevcut sayfa numarası
                certificatePage.getSize(),          // Sayfa boyutu
                certificatePage.getTotalPages(),    // Toplam sayfa sayısı
                certificatePage.getTotalElements(), // Toplam eleman sayısı
                certificatePage.isLast()            // Son sayfa kontrolü
        );
    }

    @Override
    public CertificateResponse getById(int id) {
        rule.checkData(id);
        return certificateRepository.findById(id).orElseThrow().toResponse();

    }

    @Override
    public void delete(int id) {
        rule.checkData(id);
        certificateRepository.deleteById(id);

    }

    public Certificate toEntity(CreateCertificateRequest certificateRequest){
        return Certificate.builder()
                .name(certificateRequest.getName())
                .certificateSiteLink(certificateRequest.getCertificateSiteLink())
                .givenDate(certificateRequest.getGivenDate())
                .organisationName(certificateRequest.getOrganisationName())
                .serialNumber(certificateRequest.getSerialNumber())
                .image(certificateRequest.getImage())
                .build();
    }

    public Certificate toEntity(UpdateCertificateRequest certificateRequest){
        return Certificate.builder()
                .id(certificateRequest.getId())
                .name(certificateRequest.getName())
                .certificateSiteLink(certificateRequest.getCertificateSiteLink())
                .givenDate(certificateRequest.getGivenDate())
                .organisationName(certificateRequest.getOrganisationName())
                .serialNumber(certificateRequest.getSerialNumber())
                .image(certificateRequest.getIsGetNewPicture() ? certificateRequest.getImage() : null)
                .isGetNewPicture(certificateRequest.getIsGetNewPicture())
                .build();
    }

}
