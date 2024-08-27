package com.project.portfolio.repository.certificate;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate,Integer> {
    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, int id);

    boolean existsById(int id);
}
