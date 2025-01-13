package com.project.portfolio.service.certificate;

import com.project.portfolio.controller.certificate.request.CreateCertificateRequest;
import com.project.portfolio.controller.certificate.request.UpdateCertificateRequest;
import com.project.portfolio.controller.certificate.response.CertificateResponse;
import com.project.portfolio.controller.project.response.PagedResponse;

import java.util.List;

public interface CertificateService {

    void create(CreateCertificateRequest certificateRequest);
    void update(UpdateCertificateRequest certificateRequest);
    PagedResponse<CertificateResponse> getAll(int page, int size);
    CertificateResponse getById(int id);
    void delete(int id);

}
