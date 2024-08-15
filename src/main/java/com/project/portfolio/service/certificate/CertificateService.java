package com.project.portfolio.service.certificate;

import com.project.portfolio.controller.certificate.request.CreateCertificateRequest;
import com.project.portfolio.controller.certificate.request.UpdateCertificateRequest;
import com.project.portfolio.controller.certificate.response.CertificateResponse;

import java.util.List;

public interface CertificateService {

    void create(CreateCertificateRequest certificateRequest);
    void update(UpdateCertificateRequest certificateRequest);
    List<CertificateResponse> getAll();
    CertificateResponse getById(int id);
    void delete(int id);

}
