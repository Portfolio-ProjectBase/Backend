package com.project.portfolio.controller.certificate.request;

import com.project.portfolio.core.utilities.NoFutureDate;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UpdateCertificateRequest {
    @NotNull
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String organisationName;
    @NotNull
    @NoFutureDate
    private LocalDate givenDate;
    @NotBlank
    private String certificateSiteLink;
    private String serialNumber;
}
