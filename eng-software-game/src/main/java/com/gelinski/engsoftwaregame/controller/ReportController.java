package com.gelinski.engsoftwaregame.controller;


import com.gelinski.engsoftwaregame.dto.ReportDTO;
import com.gelinski.engsoftwaregame.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService service;

    @GetMapping("/{studentId}")
    public ResponseEntity<ReportDTO> getStudentReport(@PathVariable Long studentId) {
        return ResponseEntity.ok(service.generateReportByStudent(studentId));
    }

    @GetMapping
    public ResponseEntity<List<ReportDTO>> getAllReport() {
        return ResponseEntity.ok(service.generateAllReport());
    }
}
