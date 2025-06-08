package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.FloorService;
import com.adri.proyectotfg.Infrastructure.Dto.In.FloorInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.FloorOutDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/floors")
@RequiredArgsConstructor
public class FloorController {
    private final FloorService service;

    @PostMapping
    public ResponseEntity<FloorOutDto> create(@Valid @RequestBody FloorInDto dto) {
        return ResponseEntity.ok(service.createFloor(dto));
    }

    @GetMapping
    public ResponseEntity<List<FloorOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllFloors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FloorOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getFloorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FloorOutDto> update(@PathVariable Integer id,@Valid @RequestBody FloorInDto dto) {
        return ResponseEntity.ok(service.updateFloor(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteFloor(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<FloorOutDto>> getByCompany(@PathVariable Integer companyId) {
        return ResponseEntity.ok(service.getFloorsByCompanyId(companyId));
    }
}