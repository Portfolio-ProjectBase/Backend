package com.project.portfolio.controller.certificate;

import com.project.portfolio.controller.BaseController;
import com.project.portfolio.controller.certificate.request.CreateCertificateRequest;
import com.project.portfolio.controller.certificate.request.UpdateCertificateRequest;
import com.project.portfolio.controller.certificate.response.CertificateResponse;
import com.project.portfolio.controller.skill.request.CreateSkillRequest;
import com.project.portfolio.controller.skill.request.UpdateSkillRequest;
import com.project.portfolio.service.certificate.CertificateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/certificates")
@RequiredArgsConstructor
public class CertificateController extends BaseController {

    private final CertificateService certificateService;

    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Void> create(@Valid
                                       @RequestParam("name") String name,
                                       @RequestParam("organisationName") String organisationName,
                                       @RequestParam("givenDate") LocalDate givenDate,
                                       @RequestParam("certificateSiteLink") String certificateSiteLink,
                                       @RequestParam("serialNumber") String serialNumber,
                                       @RequestPart(value = "image", required = false) MultipartFile image){
        CreateCertificateRequest request = new CreateCertificateRequest();
        request.setName(name);
        request.setOrganisationName(organisationName);
        request.setGivenDate(givenDate);
        request.setCertificateSiteLink(certificateSiteLink);
        request.setSerialNumber(serialNumber);
        if (image != null) {
            try {
                request.setImage(image.getBytes());
            } catch (IOException e) {
                return answer(HttpStatus.BAD_REQUEST); // Resim yükleme hatası durumunda
            }
        }

        certificateService.create(request);
        return answer(HttpStatus.NO_CONTENT);
    }

    @PutMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<Void> update(@Valid @RequestParam("id") int id,
                                       @RequestParam("name") String name,
                                       @RequestParam("organisationName") String organisationName,
                                       @RequestParam("givenDate") LocalDate givenDate,
                                       @RequestParam("certificateSiteLink") String certificateSiteLink,
                                       @RequestParam("serialNumber") String serialNumber,
                                       @RequestPart(value = "image", required = false) MultipartFile image){

        UpdateCertificateRequest request = UpdateCertificateRequest.builder()
                .id(id)
                .name(name)
                .organisationName(organisationName)
                .givenDate(givenDate)
                .certificateSiteLink(certificateSiteLink)
                .serialNumber(serialNumber)
                .build();
        if (image != null) {
            try {
                request.setImage(image.getBytes());
            } catch (IOException e) {
                return answer(HttpStatus.BAD_REQUEST); // Resim yükleme hatası durumunda
            }
        }
        certificateService.update(request);
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
