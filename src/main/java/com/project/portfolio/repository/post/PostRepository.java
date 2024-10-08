package com.project.portfolio.repository.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {

    boolean existsByTitle(String title);

    boolean existsByTitleAndIdNot(String title, int id);

    boolean existsById(int id);
    Page<Post> findAll(Pageable pageable);
}
