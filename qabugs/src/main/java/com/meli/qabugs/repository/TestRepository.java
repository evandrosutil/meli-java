package com.meli.qabugs.repository;

import com.meli.qabugs.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<TestCase, Long> {

    @Query("FROM TestCase where last_update >= :date")
    List<TestCase> findByLastUpdateAfter (LocalDate date);
}
