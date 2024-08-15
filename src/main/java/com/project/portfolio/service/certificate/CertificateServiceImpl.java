package com.project.portfolio.service.certificate;

import com.project.portfolio.controller.certificate.request.CreateCertificateRequest;
import com.project.portfolio.controller.certificate.request.UpdateCertificateRequest;
import com.project.portfolio.controller.certificate.response.CertificateResponse;
import com.project.portfolio.repository.certificate.Certificate;
import com.project.portfolio.repository.certificate.CertificateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService{

    private final CertificateRepository certificateRepository;

    @Override
    public void create(CreateCertificateRequest certificateRequest) {

        certificateRepository.save(toEntity(certificateRequest));

    }

    @Override
    public void update(UpdateCertificateRequest certificateRequest) {

        certificateRepository.save(toEntity(certificateRequest));

    }

    @Override
    public List<CertificateResponse> getAll() {

        List<Certificate> certificates = certificateRepository.findAll();
        List<CertificateResponse> responses = certificates.stream().map(Certificate::toResponse).toList();
        return responses;

    }

    @Override
    public CertificateResponse getById(int id) {

        return certificateRepository.findById(id).orElseThrow().toResponse();

    }

    @Override
    public void delete(int id) {

        certificateRepository.deleteById(id);

    }

    public Certificate toEntity(CreateCertificateRequest certificateRequest){
        return Certificate.builder()
                .name(certificateRequest.getName())
                .certificateSiteLink(certificateRequest.getCertificateSiteLink())
                .givenDate(certificateRequest.getGivenDate())
                .organisationName(certificateRequest.getOrganisationName())
                .serialNumber(certificateRequest.getSerialNumber())
                //.user(UserService.findById(certificateRequest.getUserId()))
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
                .build();
    }

}
