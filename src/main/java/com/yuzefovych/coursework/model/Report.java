package com.yuzefovych.coursework.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "reports")
@Data // Це від Lombok (генериться все саме)
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trainNumber;
    private String departureStation;
    private String destinationStation;
    private String departureDate;
    private String dispatcherName;
    private int wagonCount;

    @Column(columnDefinition = "TEXT")
    private String wagonNumbers;

    private String wagonType;
    private String status;
    private LocalDateTime createdAt = LocalDateTime.now();
}