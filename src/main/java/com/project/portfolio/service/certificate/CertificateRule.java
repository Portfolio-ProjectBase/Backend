package com.project.portfolio.service.certificate;

import com.project.portfolio.controller.certificate.request.CreateCertificateRequest;
import com.project.portfolio.controller.certificate.request.UpdateCertificateRequest;
import com.project.portfolio.core.exception.AlreadyExistsException;
import com.project.portfolio.core.exception.DataNotFoundException;
import com.project.portfolio.repository.certificate.CertificateRepository;
import com.project.portfolio.service.BaseRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.project.portfolio.core.exception.type.AlreadyExistsExceptionType.CERTIFICATE_EXISTS;
import static com.project.portfolio.core.exception.type.NotFoundExceptionType.*;

@Service
@RequiredArgsConstructor
public class CertificateRule implements BaseRules {
    private final CertificateRepository repository;
    public CreateCertificateRequest fix(CreateCertificateRequest request){
        request.setName(fixName(request.getName()));
        return request;
    }

    public UpdateCertificateRequest fix(UpdateCertificateRequest request){
        request.setName(fixName((request.getName())));
        return request;
    }

    public void check(CreateCertificateRequest request){
        isExistsByName(request.getName());
    }

    public void check(UpdateCertificateRequest request){
        isExistsByNameAndIdNot(request.getName(), request.getId());
    }
    @Override
    public void checkDataList(List<?> list) {
        if (list.isEmpty()){
            throw new DataNotFoundException(CERTIFICATE_LIST_NOT_FOUND);
        }
    }

    @Override
    public String fixName(String name) {
        return name;
    }

    @Override
    public void isExistsByName(String name) {
        if (repository.existsByName(name))
        {
            throw new AlreadyExistsException(CERTIFICATE_EXISTS);
        }
    }

    @Override
    public void isExistsByNameAndIdNot(String name, int id) {
        if (repository.existsByNameAndIdNot(name,id)){
            throw new AlreadyExistsException(CERTIFICATE_EXISTS);
        }
    }

    @Override
    public void checkData(int id) {
        if(!repository.existsById(id)){
            throw new DataNotFoundException(CERTIFICATE_NOT_FOUND);
        }
    }
}
