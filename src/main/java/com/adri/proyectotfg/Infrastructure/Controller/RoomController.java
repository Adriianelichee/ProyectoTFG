package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.RoomService;
import com.adri.proyectotfg.Infrastructure.Dto.In.RoomInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.RoomOutDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que gestiona las operaciones relacionadas con las salas o habitaciones.
 * Proporciona endpoints para crear, consultar, actualizar y eliminar salas,
 * así como para filtrarlas por planta.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
class RoomController {
    private final RoomService service;

    /**
     * Crea una nueva sala en el sistema.
     *
     * @param dto objeto con los datos de la sala a crear
     * @return ResponseEntity con los datos de la sala creada
     */
    @PostMapping
    public ResponseEntity<RoomOutDto> create(@Valid @RequestBody RoomInDto dto) {
        return ResponseEntity.ok(service.createRoom(dto));
    }

    /**
     * Obtiene todas las salas registradas en el sistema.
     *
     * @return ResponseEntity con la lista de todas las salas
     */
    @GetMapping
    public ResponseEntity<List<RoomOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllRooms());
    }

    /**
     * Obtiene todas las salas ubicadas en una planta específica.
     *
     * @param floorId identificador único de la planta
     * @return ResponseEntity con la lista de salas de la planta especificada
     */
    @GetMapping("/floor/{floorId}")
    public ResponseEntity<List<RoomOutDto>> getByFloor(@PathVariable Integer floorId) {
        return ResponseEntity.ok(service.getRoomsByFloor(floorId));
    }

    /**
     * Obtiene una sala específica por su identificador.
     *
     * @param id identificador único de la sala
     * @return ResponseEntity con los datos de la sala solicitada
     */
    @GetMapping("/{id}")
    public ResponseEntity<RoomOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getRoomById(id));
    }

    /**
     * Actualiza los datos de una sala existente.
     *
     * @param id  identificador único de la sala a actualizar
     * @param dto objeto con los nuevos datos de la sala
     * @return ResponseEntity con los datos actualizados de la sala
     */
    @PutMapping("/{id}")
    public ResponseEntity<RoomOutDto> update(@PathVariable Integer id, @Valid @RequestBody RoomInDto dto) {
        return ResponseEntity.ok(service.updateRoom(id, dto));
    }

    /**
     * Elimina una sala específica del sistema.
     *
     * @param id identificador único de la sala a eliminar
     * @return ResponseEntity sin contenido, con código de estado 204
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }
}