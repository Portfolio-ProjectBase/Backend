package com.project.portfolio.repository.certificate;

import com.project.portfolio.controller.certificate.response.CertificateResponse;
import com.project.portfolio.core.Base;
import com.project.portfolio.repository.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@SuperBuilder
@Table(name = "Certificates")
public class Certificate extends Base {
    @Column(name = "name")
    private String name;
    @Column(name = "organisation_name")
    private String organisationName;
    @Column(name = "given_date")
    private LocalDate givenDate;
    @Column(name = "certificate_site_link")
    private String certificateSiteLink;
    @Column(name = "serial_number")
    private String serialNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public CertificateResponse toResponse(){
        return CertificateResponse.builder()
                .name(this.name)
                .givenDate(this.givenDate)
                .certificateSiteLink(this.certificateSiteLink)
                .organisationName(this.organisationName)
                .serialNumber(this.serialNumber)
                .build();
    }

    public static Certificate fromResponse(CertificateResponse certificateResponse){
        return Certificate.builder()
                .id(certificateResponse.getId())
                .name(certificateResponse.getName())
                .serialNumber(certificateResponse.getSerialNumber())
                .organisationName(certificateResponse.getOrganisationName())
                .certificateSiteLink(certificateResponse.getCertificateSiteLink())
                .givenDate(certificateResponse.getGivenDate())
                .build();
    }

}
