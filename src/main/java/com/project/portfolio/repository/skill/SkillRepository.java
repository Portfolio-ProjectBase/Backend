package com.project.portfolio.repository.skill;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill,Integer> {

    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, int id);

    boolean existsById(int id);

}
