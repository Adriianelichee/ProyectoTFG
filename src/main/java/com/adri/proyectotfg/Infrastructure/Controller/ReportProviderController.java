package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.ReportProviderService;
import com.adri.proyectotfg.Infrastructure.Dto.In.ReportProviderInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ReportProviderOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/providers")
@RequiredArgsConstructor
class ReportProviderController {
    private final ReportProviderService service;

    @PostMapping
    public ResponseEntity<ReportProviderOutDto> create(@RequestBody ReportProviderInDto dto) {
        return ResponseEntity.ok(service.createProvider(dto));
    }

    @GetMapping
    public ResponseEntity<List<ReportProviderOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllProviders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportProviderOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getProviderById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReportProviderOutDto> update(@PathVariable Integer id, @RequestBody ReportProviderInDto dto) {
        return ResponseEntity.ok(service.updateProvider(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteProvider(id);
        return ResponseEntity.noContent().build();
    }
}