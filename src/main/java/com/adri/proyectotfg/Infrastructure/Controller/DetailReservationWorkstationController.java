package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.DetailReservationWorkstationService;
import com.adri.proyectotfg.Infrastructure.Dto.In.DetailReservationWorkstationInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.DetailReservationWorkstationOutDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/reservation-details/workstations")
@RequiredArgsConstructor
public class DetailReservationWorkstationController {
    private final DetailReservationWorkstationService service;

    @PostMapping
    public ResponseEntity<DetailReservationWorkstationOutDto> create(@Valid @RequestBody DetailReservationWorkstationInDto dto) {
        return ResponseEntity.ok(service.createDetail(dto));
    }

    @GetMapping
    public ResponseEntity<List<DetailReservationWorkstationOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailReservationWorkstationOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getDetailById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailReservationWorkstationOutDto> update(@PathVariable Integer id,@Valid @RequestBody DetailReservationWorkstationInDto dto) {
        return ResponseEntity.ok(service.updateDetail(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteDetail(id);
        return ResponseEntity.noContent().build();
    }
}
