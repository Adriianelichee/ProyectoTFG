package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.FloorService;
import com.adri.proyectotfg.Infrastructure.Dto.In.FloorInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.FloorOutDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que gestiona las operaciones relacionadas con los pisos o plantas.
 * Proporciona endpoints para crear, consultar, actualizar y eliminar pisos,
 * así como para obtener pisos asociados a una empresa específica.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/floors")
@RequiredArgsConstructor
public class FloorController {
    private final FloorService service;

    /**
     * Crea un nuevo piso en el sistema.
     *
     * @param dto objeto con los datos del piso a crear
     * @return ResponseEntity con los datos del piso creado
     */
    @PostMapping
    public ResponseEntity<FloorOutDto> create(@Valid @RequestBody FloorInDto dto) {
        return ResponseEntity.ok(service.createFloor(dto));
    }

    /**
     * Obtiene todos los pisos registrados en el sistema.
     *
     * @return ResponseEntity con la lista de todos los pisos
     */
    @GetMapping
    public ResponseEntity<List<FloorOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllFloors());
    }

    /**
     * Obtiene un piso específico por su identificador.
     *
     * @param id identificador único del piso
     * @return ResponseEntity con los datos del piso solicitado
     */
    @GetMapping("/{id}")
    public ResponseEntity<FloorOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getFloorById(id));
    }

    /**
     * Actualiza los datos de un piso existente.
     *
     * @param id  identificador único del piso a actualizar
     * @param dto objeto con los nuevos datos del piso
     * @return ResponseEntity con los datos actualizados del piso
     */
    @PutMapping("/{id}")
    public ResponseEntity<FloorOutDto> update(@PathVariable Integer id, @Valid @RequestBody FloorInDto dto) {
        return ResponseEntity.ok(service.updateFloor(id, dto));
    }

    /**
     * Elimina un piso específico del sistema.
     *
     * @param id identificador único del piso a eliminar
     * @return ResponseEntity sin contenido, con código de estado 204
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteFloor(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Obtiene todos los pisos asociados a una empresa específica.
     *
     * @param companyId identificador único de la empresa
     * @return ResponseEntity con la lista de pisos de la empresa especificada
     */
    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<FloorOutDto>> getByCompany(@PathVariable Integer companyId) {
        return ResponseEntity.ok(service.getFloorsByCompanyId(companyId));
    }
}