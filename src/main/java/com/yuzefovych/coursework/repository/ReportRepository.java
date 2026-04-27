package com.yuzefovych.coursework.repository;

import com.yuzefovych.coursework.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
    // Жодного коду писати не треба!
    // Spring Boot сам зробить усю роботу з базою даних.
}