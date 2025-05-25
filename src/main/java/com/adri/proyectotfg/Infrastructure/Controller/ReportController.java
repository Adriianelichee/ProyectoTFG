package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.ReportService;
import com.adri.proyectotfg.Infrastructure.Dto.In.ReportInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ReportOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService service;

    @PostMapping
    public ResponseEntity<ReportOutDto> create(@RequestBody ReportInDto dto) {
        return ResponseEntity.ok(service.createReport(dto));
    }

    @GetMapping
    public ResponseEntity<List<ReportOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllReports());
    }

    @GetMapping("/floor/{floorId}")
    public ResponseEntity<List<ReportOutDto>> getByFloor(@PathVariable Integer floorId) {
        return ResponseEntity.ok(service.getReportsByFloor(floorId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getReportById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReportOutDto> update(@PathVariable Integer id, @RequestBody ReportInDto dto) {
        return ResponseEntity.ok(service.updateReport(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteReport(id);
        return ResponseEntity.noContent().build();
    }
}
