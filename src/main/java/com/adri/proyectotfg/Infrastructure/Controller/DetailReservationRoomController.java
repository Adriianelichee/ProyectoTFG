package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.DetailReservationRoomService;
import com.adri.proyectotfg.Infrastructure.Dto.In.DetailReservationRoomInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.DetailReservationRoomOutDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/reservation-details/rooms")
@RequiredArgsConstructor
public class DetailReservationRoomController {
    private final DetailReservationRoomService service;

    @PostMapping
    public ResponseEntity<DetailReservationRoomOutDto> create(@Valid @RequestBody DetailReservationRoomInDto dto) {
        return ResponseEntity.ok(service.createDetail(dto));
    }

    @GetMapping
    public ResponseEntity<List<DetailReservationRoomOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetailReservationRoomOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getDetailById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetailReservationRoomOutDto> update(@PathVariable Integer id, @Valid @RequestBody DetailReservationRoomInDto dto) {
        return ResponseEntity.ok(service.updateDetail(id, dto));
    }

    @GetMapping("/reservation/{reservationId}")
    public ResponseEntity<DetailReservationRoomOutDto> getByReservationId(@PathVariable Integer reservationId) {
        return ResponseEntity.ok(service.getDetailByReservationId(reservationId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteDetail(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/occupied")
    public ResponseEntity<List<DetailReservationRoomOutDto>> getOccupiedRoomDetails() {
        return ResponseEntity.ok(service.getOccupiedRoomDetails());
    }

    @GetMapping("/occupied/room/{roomId}")
    public ResponseEntity<List<DetailReservationRoomOutDto>> getOccupiedRoomDetailsByRoom(@PathVariable Integer roomId) {
        return ResponseEntity.ok(service.getOccupiedRoomDetailsByRoom(roomId));
    }

    @GetMapping("/occupied/date-range")
    public ResponseEntity<List<DetailReservationRoomOutDto>> getOccupiedRoomDetailsBetweenDates(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return ResponseEntity.ok(service.getOccupiedRoomDetailsBetweenDates(start, end));
    }
}