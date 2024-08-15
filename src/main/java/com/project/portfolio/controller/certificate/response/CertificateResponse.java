package com.project.portfolio.controller.certificate.response;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CertificateResponse {
    int id;
    String name;
    String organisationName;
    LocalDate givenDate;
    String certificateSiteLink;
    String serialNumber;
}
