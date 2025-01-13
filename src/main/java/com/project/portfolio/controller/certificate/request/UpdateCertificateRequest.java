package com.project.portfolio.controller.certificate.request;

import com.project.portfolio.core.utilities.NoFutureDate;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
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
    private byte[] image;
    private Boolean isGetNewPicture;
}
