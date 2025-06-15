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

/**
 * Controlador REST que gestiona las operaciones relacionadas con los detalles de reservas de habitaciones.
 * Proporciona endpoints para crear, consultar, actualizar y eliminar detalles de reservas,
 * así como para obtener información sobre habitaciones ocupadas en diferentes períodos.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/reservation-details/rooms")
@RequiredArgsConstructor
public class DetailReservationRoomController {
    private final DetailReservationRoomService service;

    /**
     * Crea un nuevo detalle de reserva de habitación.
     *
     * @param dto objeto con los datos del detalle de reserva a crear
     * @return ResponseEntity con los datos del detalle de reserva creado
     */
    @PostMapping
    public ResponseEntity<DetailReservationRoomOutDto> create(@Valid @RequestBody DetailReservationRoomInDto dto) {
        return ResponseEntity.ok(service.createDetail(dto));
    }

    /**
     * Obtiene todos los detalles de reservas de habitaciones registrados.
     *
     * @return ResponseEntity con la lista de todos los detalles de reservas
     */
    @GetMapping
    public ResponseEntity<List<DetailReservationRoomOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllDetails());
    }

    /**
     * Obtiene un detalle de reserva específico por su identificador.
     *
     * @param id identificador único del detalle de reserva
     * @return ResponseEntity con los datos del detalle de reserva solicitado
     */
    @GetMapping("/{id}")
    public ResponseEntity<DetailReservationRoomOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getDetailById(id));
    }

    /**
     * Actualiza los datos de un detalle de reserva existente.
     *
     * @param id  identificador único del detalle de reserva a actualizar
     * @param dto objeto con los nuevos datos del detalle de reserva
     * @return ResponseEntity con los datos actualizados del detalle de reserva
     */
    @PutMapping("/{id}")
    public ResponseEntity<DetailReservationRoomOutDto> update(@PathVariable Integer id, @Valid @RequestBody DetailReservationRoomInDto dto) {
        return ResponseEntity.ok(service.updateDetail(id, dto));
    }

    /**
     * Obtiene el detalle de reserva asociado a una reserva específica.
     *
     * @param reservationId identificador único de la reserva
     * @return ResponseEntity con los datos del detalle de reserva asociado
     */
    @GetMapping("/reservation/{reservationId}")
    public ResponseEntity<DetailReservationRoomOutDto> getByReservationId(@PathVariable Integer reservationId) {
        return ResponseEntity.ok(service.getDetailByReservationId(reservationId));
    }

    /**
     * Elimina un detalle de reserva específico.
     *
     * @param id identificador único del detalle de reserva a eliminar
     * @return ResponseEntity sin contenido, con código de estado 204
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteDetail(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Obtiene todos los detalles de reservas de habitaciones que están actualmente ocupadas.
     *
     * @return ResponseEntity con la lista de detalles de habitaciones ocupadas
     */
    @GetMapping("/occupied")
    public ResponseEntity<List<DetailReservationRoomOutDto>> getOccupiedRoomDetails() {
        return ResponseEntity.ok(service.getOccupiedRoomDetails());
    }

    /**
     * Obtiene los detalles de reservas para una habitación específica que está ocupada.
     *
     * @param roomId identificador único de la habitación
     * @return ResponseEntity con la lista de detalles de reserva para la habitación especificada
     */
    @GetMapping("/occupied/room/{roomId}")
    public ResponseEntity<List<DetailReservationRoomOutDto>> getOccupiedRoomDetailsByRoom(@PathVariable Integer roomId) {
        return ResponseEntity.ok(service.getOccupiedRoomDetailsByRoom(roomId));
    }

    /**
     * Obtiene los detalles de reservas de habitaciones ocupadas en un rango de fechas específico.
     *
     * @param start fecha y hora de inicio del rango de búsqueda
     * @param end   fecha y hora de fin del rango de búsqueda
     * @return ResponseEntity con la lista de detalles de habitaciones ocupadas en el rango especificado
     */
    @GetMapping("/occupied/date-range")
    public ResponseEntity<List<DetailReservationRoomOutDto>> getOccupiedRoomDetailsBetweenDates(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return ResponseEntity.ok(service.getOccupiedRoomDetailsBetweenDates(start, end));
    }
}