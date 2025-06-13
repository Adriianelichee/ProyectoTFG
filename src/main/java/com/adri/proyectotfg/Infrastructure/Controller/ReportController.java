package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.ReportService;
import com.adri.proyectotfg.Infrastructure.Dto.In.ReportInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ReportOutDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService service;

    @PostMapping
    public ResponseEntity<ReportOutDto> create(@Valid @RequestBody ReportInDto dto) {
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

    @PatchMapping("/{id}/status")
    public ResponseEntity<ReportOutDto> updateStatus(
            @PathVariable Integer id,
            @RequestBody Map<String, String> statusMap) {

        String newStatus = statusMap.get("status");
        if (newStatus == null) {
            throw new IllegalArgumentException("El campo 'status' es requerido");
        }
        return ResponseEntity.ok(service.updateReportStatus(id, newStatus));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReportOutDto> update(@PathVariable Integer id, @Valid @RequestBody ReportInDto dto) {
        return ResponseEntity.ok(service.updateReport(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteReport(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReportOutDto>> getByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(service.getReportsByUserId(userId));
    }

}
