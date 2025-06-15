package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.ReservationService;
import com.adri.proyectotfg.Infrastructure.Dto.In.ReservationInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ReservationOutDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que gestiona las operaciones relacionadas con las reservas.
 * Proporciona endpoints para crear, consultar, actualizar y eliminar reservas,
 * así como para filtrarlas por usuario o por estado.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService service;

    /**
     * Crea una nueva reserva en el sistema.
     *
     * @param dto objeto con los datos de la reserva a crear
     * @return ResponseEntity con los datos de la reserva creada
     */
    @PostMapping
    public ResponseEntity<ReservationOutDto> create(@Valid @RequestBody ReservationInDto dto) {
        return ResponseEntity.ok(service.createReservation(dto));
    }

    /**
     * Obtiene todas las reservas registradas en el sistema.
     *
     * @return ResponseEntity con la lista de todas las reservas
     */
    @GetMapping
    public ResponseEntity<List<ReservationOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllReservations());
    }

    /**
     * Obtiene todas las reservas realizadas por un usuario específico.
     *
     * @param userId identificador único del usuario
     * @return ResponseEntity con la lista de reservas del usuario especificado
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReservationOutDto>> getByUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(service.getReservationsByUser(userId));
    }

    /**
     * Obtiene todas las reservas que se encuentran en un estado específico.
     *
     * @param status estado de las reservas a filtrar
     * @return ResponseEntity con la lista de reservas que coinciden con el estado especificado
     */
    @GetMapping("/status/{status}")
    public ResponseEntity<List<ReservationOutDto>> getByStatus(@PathVariable String status) {
        return ResponseEntity.ok(service.getReservationsByStatus(status));
    }

    /**
     * Obtiene una reserva específica por su identificador.
     *
     * @param id identificador único de la reserva
     * @return ResponseEntity con los datos de la reserva solicitada
     */
    @GetMapping("/{id}")
    public ResponseEntity<ReservationOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getReservationById(id));
    }

    /**
     * Actualiza los datos de una reserva existente.
     *
     * @param id  identificador único de la reserva a actualizar
     * @param dto objeto con los nuevos datos de la reserva
     * @return ResponseEntity con los datos actualizados de la reserva
     */
    @PutMapping("/{id}")
    public ResponseEntity<ReservationOutDto> update(@PathVariable Integer id, @Valid @RequestBody ReservationInDto dto) {
        return ResponseEntity.ok(service.updateReservation(id, dto));
    }

    /**
     * Elimina una reserva específica del sistema.
     *
     * @param id identificador único de la reserva a eliminar
     * @return ResponseEntity sin contenido, con código de estado 204
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}