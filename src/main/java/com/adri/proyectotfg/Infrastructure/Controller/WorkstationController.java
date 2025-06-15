package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.WorkstationService;
import com.adri.proyectotfg.Infrastructure.Dto.In.WorkstationInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.WorkstationOutDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que gestiona las operaciones relacionadas con las estaciones de trabajo.
 * Proporciona endpoints para crear, consultar, actualizar y eliminar estaciones de trabajo,
 * así como para filtrarlas por planta.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/workstations")
@RequiredArgsConstructor
class WorkstationController {
    private final WorkstationService service;

    /**
     * Crea una nueva estación de trabajo en el sistema.
     *
     * @param dto objeto con los datos de la estación de trabajo a crear
     * @return ResponseEntity con los datos de la estación de trabajo creada
     */
    @PostMapping
    public ResponseEntity<WorkstationOutDto> create(@Valid @RequestBody WorkstationInDto dto) {
        return ResponseEntity.ok(service.createWorkstation(dto));
    }

    /**
     * Obtiene todas las estaciones de trabajo registradas en el sistema.
     *
     * @return ResponseEntity con la lista de todas las estaciones de trabajo
     */
    @GetMapping
    public ResponseEntity<List<WorkstationOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllWorkstations());
    }

    /**
     * Obtiene todas las estaciones de trabajo ubicadas en una planta específica.
     *
     * @param floorId identificador único de la planta
     * @return ResponseEntity con la lista de estaciones de trabajo de la planta especificada
     */
    @GetMapping("/floor/{floorId}")
    public ResponseEntity<List<WorkstationOutDto>> getByFloor(@PathVariable Integer floorId) {
        return ResponseEntity.ok(service.getWorkstationsByFloor(floorId));
    }

    /**
     * Obtiene una estación de trabajo específica por su identificador.
     *
     * @param id identificador único de la estación de trabajo
     * @return ResponseEntity con los datos de la estación de trabajo solicitada
     */
    @GetMapping("/{id}")
    public ResponseEntity<WorkstationOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getWorkstationById(id));
    }

    /**
     * Actualiza los datos de una estación de trabajo existente.
     *
     * @param id  identificador único de la estación de trabajo a actualizar
     * @param dto objeto con los nuevos datos de la estación de trabajo
     * @return ResponseEntity con los datos actualizados de la estación de trabajo
     */
    @PutMapping("/{id}")
    public ResponseEntity<WorkstationOutDto> update(@PathVariable Integer id, @Valid @RequestBody WorkstationInDto dto) {
        return ResponseEntity.ok(service.updateWorkstation(id, dto));
    }

    /**
     * Elimina una estación de trabajo específica del sistema.
     *
     * @param id identificador único de la estación de trabajo a eliminar
     * @return ResponseEntity sin contenido, con código de estado 204
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteWorkstation(id);
        return ResponseEntity.noContent().build();
    }
}