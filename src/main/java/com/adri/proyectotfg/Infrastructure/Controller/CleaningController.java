package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.CleaningService;
import com.adri.proyectotfg.Infrastructure.Dto.In.CleaningInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.CleaningOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/cleanings")
@RequiredArgsConstructor
public class CleaningController {
    private final CleaningService service;

    @PostMapping
    public ResponseEntity<CleaningOutDto> create(@RequestBody CleaningInDto dto) {
        return ResponseEntity.ok(service.createCleaning(dto));
    }

    @GetMapping
    public ResponseEntity<List<CleaningOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllCleanings());
    }

    @GetMapping("/floor/{floorId}")
    public ResponseEntity<List<CleaningOutDto>> getByFloor(@PathVariable Integer floorId) {
        return ResponseEntity.ok(service.getCleaningsByFloor(floorId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CleaningOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getCleaningById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CleaningOutDto> update(@PathVariable Integer id, @RequestBody CleaningInDto dto) {
        return ResponseEntity.ok(service.updateCleaning(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteCleaning(id);
        return ResponseEntity.noContent().build();
    }
}