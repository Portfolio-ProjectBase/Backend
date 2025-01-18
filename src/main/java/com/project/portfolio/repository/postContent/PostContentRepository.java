package com.project.portfolio.repository.postContent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PostContentRepository extends JpaRepository<PostContent,Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM PostContent pc WHERE pc.id IN (:ids)")
    void deleteAllById(@Param("ids") List<Integer> ids);
}
