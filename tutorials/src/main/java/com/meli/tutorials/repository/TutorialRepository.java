package com.meli.tutorials.repository;

import com.meli.tutorials.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

    @Query("FROM Tutorial WHERE status = 'published'")
    List<Tutorial> findPublished();

    @Query("FROM Tutorial  WHERE title like %:title%")
    List<Tutorial> findByTitle(@Param("title") String title);
}
