package com.yuzefovych.coursework.controller;

import com.yuzefovych.coursework.model.Report;
import com.yuzefovych.coursework.model.Wagon;
import com.yuzefovych.coursework.repository.ReportRepository;
import com.yuzefovych.coursework.service.SortingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/sorting")
@CrossOrigin(origins = "*")
public class SortingController {

    private final SortingService sortingService;

    @Autowired // Можна залишити тут для зручності
    private ReportRepository reportRepository;

    public SortingController(SortingService sortingService) {
        this.sortingService = sortingService;
    }

    // 1. Обробка сортування (твоя стара логіка)
    @PostMapping("/process")
    public Map<String, List<Wagon>> processSorting(@RequestBody List<Wagon> wagons) {
        return sortingService.sortWagonsByRoute(wagons);
    }

    // 2. Збереження звіту в базу H2
    @PostMapping("/reports/save")
    public Report saveReport(@RequestBody Report report) {
        System.out.println("--- ЗБЕРЕЖЕННЯ В БД ---");
        System.out.println("Потяг №: " + report.getTrainNumber());
        return reportRepository.save(report);
    }

    // 3. Отримання всього архіву для сторінки звітів
    @GetMapping("/reports/all")
    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    @DeleteMapping("/reports/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        reportRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}