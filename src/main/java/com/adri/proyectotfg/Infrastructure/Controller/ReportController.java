package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.ReportService;
import com.adri.proyectotfg.Infrastructure.Dto.In.ReportInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ReportOutDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Controlador REST que gestiona las operaciones relacionadas con los reportes o incidencias.
 * Proporciona endpoints para crear, consultar, actualizar y eliminar reportes,
 * así como para filtrarlos por planta o por usuario y actualizar su estado.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService service;

    /**
     * Crea un nuevo reporte en el sistema.
     *
     * @param dto objeto con los datos del reporte a crear
     * @return ResponseEntity con los datos del reporte creado
     */
    @PostMapping
    public ResponseEntity<ReportOutDto> create(@Valid @RequestBody ReportInDto dto) {
        return ResponseEntity.ok(service.createReport(dto));
    }

    /**
     * Obtiene todos los reportes registrados en el sistema.
     *
     * @return ResponseEntity con la lista de todos los reportes
     */
    @GetMapping
    public ResponseEntity<List<ReportOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllReports());
    }

    /**
     * Obtiene todos los reportes asociados a una planta específica.
     *
     * @param floorId identificador único de la planta
     * @return ResponseEntity con la lista de reportes de la planta especificada
     */
    @GetMapping("/floor/{floorId}")
    public ResponseEntity<List<ReportOutDto>> getByFloor(@PathVariable Integer floorId) {
        return ResponseEntity.ok(service.getReportsByFloor(floorId));
    }

    /**
     * Obtiene un reporte específico por su identificador.
     *
     * @param id identificador único del reporte
     * @return ResponseEntity con los datos del reporte solicitado
     */
    @GetMapping("/{id}")
    public ResponseEntity<ReportOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getReportById(id));
    }

    /**
     * Actualiza únicamente el estado de un reporte existente.
     *
     * @param id        identificador único del reporte cuyo estado se va a actualizar
     * @param statusMap objeto con el nuevo estado del reporte
     * @return ResponseEntity con los datos actualizados del reporte
     * @throws IllegalArgumentException si no se proporciona el campo 'status' en el cuerpo de la solicitud
     */
    @PatchMapping("/{id}/status")
    public ResponseEntity<ReportOutDto> updateStatus(
            @PathVariable Integer id,
            @RequestBody Map<String, String> statusMap) {

        String newStatus = statusMap.get("status");
        if (newStatus == null) {
            throw new IllegalArgumentException("El campo 'status' es requerido");
        }
        return ResponseEntity.ok(service.updateReportStatus(id, newStatus));
    }

    /**
     * Actualiza los datos de un reporte existente.
     *
     * @param id  identificador único del reporte a actualizar
     * @param dto objeto con los nuevos datos del reporte
     * @return ResponseEntity con los datos actualizados del reporte
     */
    @PutMapping("/{id}")
    public ResponseEntity<ReportOutDto> update(@PathVariable Integer id, @Valid @RequestBody ReportInDto dto) {
        return ResponseEntity.ok(service.updateReport(id, dto));
    }

    /**
     * Elimina un reporte específico del sistema.
     *
     * @param id identificador único del reporte a eliminar
     * @return ResponseEntity sin contenido, con código de estado 204
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteReport(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Obtiene todos los reportes creados por un usuario específico.
     *
     * @param userId identificador único del usuario
     * @return ResponseEntity con la lista de reportes del usuario especificado
     */
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ReportOutDto>> getByUserId(@PathVariable Integer userId) {
        return ResponseEntity.ok(service.getReportsByUserId(userId));
    }
}