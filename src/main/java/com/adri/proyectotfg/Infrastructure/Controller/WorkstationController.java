package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.WorkstationService;
import com.adri.proyectotfg.Infrastructure.Dto.In.WorkstationInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.WorkstationOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/workstations")
@RequiredArgsConstructor
class WorkstationController {
    private final WorkstationService service;

    @PostMapping
    public ResponseEntity<WorkstationOutDto> create(@RequestBody WorkstationInDto dto) {
        return ResponseEntity.ok(service.createWorkstation(dto));
    }

    @GetMapping
    public ResponseEntity<List<WorkstationOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllWorkstations());
    }

    @GetMapping("/floor/{floorId}")
    public ResponseEntity<List<WorkstationOutDto>> getByFloor(@PathVariable Integer floorId) {
        return ResponseEntity.ok(service.getWorkstationsByFloor(floorId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkstationOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getWorkstationById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkstationOutDto> update(@PathVariable Integer id, @RequestBody WorkstationInDto dto) {
        return ResponseEntity.ok(service.updateWorkstation(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteWorkstation(id);
        return ResponseEntity.noContent().build();
    }
}