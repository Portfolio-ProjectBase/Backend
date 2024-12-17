package com.project.portfolio.controller.certificate.response;

import com.project.portfolio.controller.ImageBaseResponse;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class CertificateResponse extends ImageBaseResponse {
    int id;
    String name;
    String organisationName;
    LocalDate givenDate;
    String certificateSiteLink;
    String serialNumber;

}
