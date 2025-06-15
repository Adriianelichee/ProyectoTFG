package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.ReportProviderService;
import com.adri.proyectotfg.Infrastructure.Dto.In.ReportProviderInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ReportProviderOutDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que gestiona las operaciones relacionadas con los proveedores de reportes.
 * Proporciona endpoints para crear, consultar, actualizar y eliminar proveedores de reportes.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/providers")
@RequiredArgsConstructor
class ReportProviderController {
    private final ReportProviderService service;

    /**
     * Crea un nuevo proveedor de reportes en el sistema.
     *
     * @param dto objeto con los datos del proveedor a crear
     * @return ResponseEntity con los datos del proveedor creado
     */
    @PostMapping
    public ResponseEntity<ReportProviderOutDto> create(@Valid @RequestBody ReportProviderInDto dto) {
        return ResponseEntity.ok(service.createProvider(dto));
    }

    /**
     * Obtiene todos los proveedores de reportes registrados en el sistema.
     *
     * @return ResponseEntity con la lista de todos los proveedores
     */
    @GetMapping
    public ResponseEntity<List<ReportProviderOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllProviders());
    }

    /**
     * Obtiene un proveedor de reportes específico por su identificador.
     *
     * @param id identificador único del proveedor
     * @return ResponseEntity con los datos del proveedor solicitado
     */
    @GetMapping("/{id}")
    public ResponseEntity<ReportProviderOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getProviderById(id));
    }

    /**
     * Actualiza los datos de un proveedor de reportes existente.
     *
     * @param id  identificador único del proveedor a actualizar
     * @param dto objeto con los nuevos datos del proveedor
     * @return ResponseEntity con los datos actualizados del proveedor
     */
    @PutMapping("/{id}")
    public ResponseEntity<ReportProviderOutDto> update(@PathVariable Integer id, @Valid @RequestBody ReportProviderInDto dto) {
        return ResponseEntity.ok(service.updateProvider(id, dto));
    }

    /**
     * Elimina un proveedor de reportes específico del sistema.
     *
     * @param id identificador único del proveedor a eliminar
     * @return ResponseEntity sin contenido, con código de estado 204
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteProvider(id);
        return ResponseEntity.noContent().build();
    }
}