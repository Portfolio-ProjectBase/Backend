package com.project.portfolio.controller.certificate.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CertificateResponse {
    int id;
    String name;
    String organisationName;
    LocalDate givenDate;
    String certificateSiteLink;
}
