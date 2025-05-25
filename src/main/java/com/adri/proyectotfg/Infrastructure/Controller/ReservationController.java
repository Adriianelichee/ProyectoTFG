package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.PaymentService;
import com.adri.proyectotfg.Application.Service.ReservationService;
import com.adri.proyectotfg.Infrastructure.Dto.In.PaymentInDto;
import com.adri.proyectotfg.Infrastructure.Dto.In.ReservationInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.PaymentOutDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ReservationOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService service;

    @PostMapping
    public ResponseEntity<ReservationOutDto> create(@RequestBody ReservationInDto dto) {
        return ResponseEntity.ok(service.createReservation(dto));
    }

    @GetMapping
    public ResponseEntity<List<ReservationOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllReservations());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReservationOutDto>> getByUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(service.getReservationsByUser(userId));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ReservationOutDto>> getByStatus(@PathVariable String status) {
        return ResponseEntity.ok(service.getReservationsByStatus(status));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getReservationById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservationOutDto> update(@PathVariable Integer id, @RequestBody ReservationInDto dto) {
        return ResponseEntity.ok(service.updateReservation(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}