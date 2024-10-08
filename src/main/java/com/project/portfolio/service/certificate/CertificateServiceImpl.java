package com.project.portfolio.service.certificate;

import com.project.portfolio.controller.certificate.request.CreateCertificateRequest;
import com.project.portfolio.controller.certificate.request.UpdateCertificateRequest;
import com.project.portfolio.controller.certificate.response.CertificateResponse;
import com.project.portfolio.repository.certificate.Certificate;
import com.project.portfolio.repository.certificate.CertificateRepository;
import com.project.portfolio.repository.user.User;
import com.project.portfolio.service.user.UserService;
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
        certificateRepository.save(toEntity(certificateRequest));

    }

    @Override
    public List<CertificateResponse> getAll() {

        List<Certificate> certificates = certificateRepository.findAll();
        rule.checkDataList(certificates);
        List<CertificateResponse> responses = certificates.stream().map(Certificate::toResponse).toList();
        return responses;

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
