package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.CleaningService;
import com.adri.proyectotfg.Infrastructure.Dto.In.CleaningInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.CleaningOutDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que maneja las operaciones CRUD para las tareas de limpieza.
 * Proporciona endpoints para crear, leer, actualizar y eliminar tareas de limpieza.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/cleanings")
@RequiredArgsConstructor
public class CleaningController {
    private final CleaningService service;

    /**
     * Crea una nueva tarea de limpieza.
     *
     * @param dto objeto con los datos de la tarea de limpieza a crear
     * @return ResponseEntity con los datos de la tarea de limpieza creada
     */
    @PostMapping
    public ResponseEntity<CleaningOutDto> create(@Valid @RequestBody CleaningInDto dto) {
        return ResponseEntity.ok(service.createCleaning(dto));
    }

    /**
     * Obtiene todas las tareas de limpieza registradas.
     *
     * @return ResponseEntity con la lista de todas las tareas de limpieza
     */
    @GetMapping
    public ResponseEntity<List<CleaningOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllCleanings());
    }

    /**
     * Obtiene todas las tareas de limpieza asociadas a un piso específico.
     *
     * @param floorId identificador único del piso
     * @return ResponseEntity con la lista de tareas de limpieza del piso especificado
     */
    @GetMapping("/floor/{floorId}")
    public ResponseEntity<List<CleaningOutDto>> getByFloor(@PathVariable Integer floorId) {
        return ResponseEntity.ok(service.getCleaningsByFloor(floorId));
    }

    /**
     * Obtiene una tarea de limpieza específica por su identificador.
     *
     * @param id identificador único de la tarea de limpieza
     * @return ResponseEntity con los datos de la tarea de limpieza solicitada
     */
    @GetMapping("/{id}")
    public ResponseEntity<CleaningOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getCleaningById(id));
    }

    /**
     * Actualiza los datos de una tarea de limpieza existente.
     *
     * @param id  identificador único de la tarea de limpieza a actualizar
     * @param dto objeto con los nuevos datos de la tarea de limpieza
     * @return ResponseEntity con los datos actualizados de la tarea de limpieza
     */
    @PutMapping("/{id}")
    public ResponseEntity<CleaningOutDto> update(@PathVariable Integer id, @Valid @RequestBody CleaningInDto dto) {
        return ResponseEntity.ok(service.updateCleaning(id, dto));
    }

    /**
     * Elimina una tarea de limpieza específica.
     *
     * @param id identificador único de la tarea de limpieza a eliminar
     * @return ResponseEntity sin contenido, con código de estado 204
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteCleaning(id);
        return ResponseEntity.noContent().build();
    }
}