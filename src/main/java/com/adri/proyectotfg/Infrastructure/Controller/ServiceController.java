package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.ServicesService;
import com.adri.proyectotfg.Infrastructure.Dto.In.ServiceInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ServiceOutDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que gestiona las operaciones relacionadas con los servicios.
 * Proporciona endpoints para crear, consultar, actualizar y eliminar servicios.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class ServiceController {
    private final ServicesService service;

    /**
     * Crea un nuevo servicio en el sistema.
     *
     * @param dto objeto con los datos del servicio a crear
     * @return ResponseEntity con los datos del servicio creado
     */
    @PostMapping
    public ResponseEntity<ServiceOutDto> create(@Valid @RequestBody ServiceInDto dto) {
        return ResponseEntity.ok(service.createService(dto));
    }

    /**
     * Obtiene todos los servicios registrados en el sistema.
     *
     * @return ResponseEntity con la lista de todos los servicios
     */
    @GetMapping
    public ResponseEntity<List<ServiceOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllServices());
    }

    /**
     * Obtiene un servicio específico por su identificador.
     *
     * @param id identificador único del servicio
     * @return ResponseEntity con los datos del servicio solicitado
     */
    @GetMapping("/{id}")
    public ResponseEntity<ServiceOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getServiceById(id));
    }

    /**
     * Actualiza los datos de un servicio existente.
     *
     * @param id  identificador único del servicio a actualizar
     * @param dto objeto con los nuevos datos del servicio
     * @return ResponseEntity con los datos actualizados del servicio
     */
    @PutMapping("/{id}")
    public ResponseEntity<ServiceOutDto> update(@PathVariable Integer id, @Valid @RequestBody ServiceInDto dto) {
        return ResponseEntity.ok(service.updateService(id, dto));
    }

    /**
     * Elimina un servicio específico del sistema.
     *
     * @param id identificador único del servicio a eliminar
     * @return ResponseEntity sin contenido, con código de estado 204
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}