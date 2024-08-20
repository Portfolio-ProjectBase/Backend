package com.project.portfolio.controller.certificate;

import com.project.portfolio.controller.BaseController;
import com.project.portfolio.controller.certificate.request.CreateCertificateRequest;
import com.project.portfolio.controller.certificate.request.UpdateCertificateRequest;
import com.project.portfolio.controller.certificate.response.CertificateResponse;
import com.project.portfolio.service.certificate.CertificateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/certificates")
@RequiredArgsConstructor
public class CertificateController extends BaseController {

    private final CertificateService certificateService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateCertificateRequest certificateRequest){
        certificateService.create(certificateRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody @Valid UpdateCertificateRequest updateCertificateRequest){
        certificateService.update(updateCertificateRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CertificateResponse> getById(@PathVariable int id){
        CertificateResponse response = certificateService.getById(id);
        return answer(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CertificateResponse>> getAll(){
        List<CertificateResponse> responses = certificateService.getAll();
        return answer(responses, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        certificateService.delete(id);
        return answer(HttpStatus.NO_CONTENT);
    }
}
