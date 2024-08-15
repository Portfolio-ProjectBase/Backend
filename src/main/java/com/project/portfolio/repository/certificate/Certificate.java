package com.project.portfolio.repository.certificate;

import com.project.portfolio.core.Base;
import com.project.portfolio.repository.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
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

}
