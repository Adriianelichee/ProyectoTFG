package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.DetailReservationWorkstationService;
import com.adri.proyectotfg.Infrastructure.Dto.In.DetailReservationWorkstationInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.DetailReservationWorkstationOutDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    @GetMapping("/workstation/{workstationId}")
    public ResponseEntity<List<DetailReservationWorkstationOutDto>> getByWorkstation(@PathVariable Integer workstationId) {
        return ResponseEntity.ok(service.getDetailsByWorkstation(workstationId));
    }

    @GetMapping("/occupied")
    public ResponseEntity<List<DetailReservationWorkstationOutDto>> getOccupiedBetweenDates(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return ResponseEntity.ok(service.getOccupiedWorkstationDetailsBetweenDates(startDate, endDate));
    }

    @GetMapping("/reservation/{reservationId}")
    public ResponseEntity<DetailReservationWorkstationOutDto> getByReservation(@PathVariable Integer reservationId) {
        return ResponseEntity.ok(service.getDetailsByReservation(reservationId));
    }
}
