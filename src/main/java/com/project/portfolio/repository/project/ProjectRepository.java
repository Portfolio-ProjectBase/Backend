package com.project.portfolio.repository.project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
    boolean existsByTitle(String name);

    boolean existsByTitleAndIdNot(String name, int id);

    boolean existsById(int id);
    Page<Project> findAll(Pageable pageable);
}