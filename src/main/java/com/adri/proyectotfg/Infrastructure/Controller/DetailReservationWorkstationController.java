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

/**
 * Controlador REST que gestiona las operaciones relacionadas con los detalles de reservas de puestos de trabajo.
 * Proporciona endpoints para crear, consultar, actualizar y eliminar detalles de reservas,
 * así como para obtener información sobre puestos ocupados en diferentes períodos.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/reservation-details/workstations")
@RequiredArgsConstructor
public class DetailReservationWorkstationController {
    private final DetailReservationWorkstationService service;

    /**
     * Crea un nuevo detalle de reserva de puesto de trabajo.
     *
     * @param dto objeto con los datos del detalle de reserva a crear
     * @return ResponseEntity con los datos del detalle de reserva creado
     */
    @PostMapping
    public ResponseEntity<DetailReservationWorkstationOutDto> create(@Valid @RequestBody DetailReservationWorkstationInDto dto) {
        return ResponseEntity.ok(service.createDetail(dto));
    }

    /**
     * Obtiene todos los detalles de reservas de puestos de trabajo registrados.
     *
     * @return ResponseEntity con la lista de todos los detalles de reservas
     */
    @GetMapping
    public ResponseEntity<List<DetailReservationWorkstationOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllDetails());
    }

    /**
     * Obtiene un detalle de reserva específico por su identificador.
     *
     * @param id identificador único del detalle de reserva
     * @return ResponseEntity con los datos del detalle de reserva solicitado
     */
    @GetMapping("/{id}")
    public ResponseEntity<DetailReservationWorkstationOutDto> getById(@PathVariable Integer id) {
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
    public ResponseEntity<DetailReservationWorkstationOutDto> update(@PathVariable Integer id, @Valid @RequestBody DetailReservationWorkstationInDto dto) {
        return ResponseEntity.ok(service.updateDetail(id, dto));
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
     * Obtiene todos los detalles de reservas asociados a un puesto de trabajo específico.
     *
     * @param workstationId identificador único del puesto de trabajo
     * @return ResponseEntity con la lista de detalles de reserva para el puesto especificado
     */
    @GetMapping("/workstation/{workstationId}")
    public ResponseEntity<List<DetailReservationWorkstationOutDto>> getByWorkstation(@PathVariable Integer workstationId) {
        return ResponseEntity.ok(service.getDetailsByWorkstation(workstationId));
    }

    /**
     * Obtiene los detalles de reservas de puestos de trabajo ocupados en un rango de fechas específico.
     *
     * @param startDate fecha y hora de inicio del rango de búsqueda
     * @param endDate   fecha y hora de fin del rango de búsqueda
     * @return ResponseEntity con la lista de detalles de puestos ocupados en el rango especificado
     */
    @GetMapping("/occupied")
    public ResponseEntity<List<DetailReservationWorkstationOutDto>> getOccupiedBetweenDates(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate) {
        return ResponseEntity.ok(service.getOccupiedWorkstationDetailsBetweenDates(startDate, endDate));
    }

    /**
     * Obtiene el detalle de reserva asociado a una reserva específica.
     *
     * @param reservationId identificador único de la reserva
     * @return ResponseEntity con los datos del detalle de reserva asociado
     */
    @GetMapping("/reservation/{reservationId}")
    public ResponseEntity<DetailReservationWorkstationOutDto> getByReservation(@PathVariable Integer reservationId) {
        return ResponseEntity.ok(service.getDetailsByReservation(reservationId));
    }
}