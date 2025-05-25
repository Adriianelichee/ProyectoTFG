package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.RoomService;
import com.adri.proyectotfg.Infrastructure.Dto.In.RoomInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.RoomOutDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
class RoomController {
    private final RoomService service;

    @PostMapping
    public ResponseEntity<RoomOutDto> create(@Valid @RequestBody RoomInDto dto) {
        return ResponseEntity.ok(service.createRoom(dto));
    }

    @GetMapping
    public ResponseEntity<List<RoomOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllRooms());
    }

    @GetMapping("/floor/{floorId}")
    public ResponseEntity<List<RoomOutDto>> getByFloor(@PathVariable Integer floorId) {
        return ResponseEntity.ok(service.getRoomsByFloor(floorId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getRoomById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomOutDto> update(@PathVariable Integer id,@Valid @RequestBody RoomInDto dto) {
        return ResponseEntity.ok(service.updateRoom(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }
}