package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.CompanyService;
import com.adri.proyectotfg.Infrastructure.Dto.In.CompanyInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.CompanyOutDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que maneja las operaciones CRUD para las compañías.
 * Proporciona endpoints para crear, leer, actualizar y eliminar compañías.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
class CompanyController {
    private final CompanyService service;

    /**
     * Crea una nueva compañía.
     *
     * @param dto objeto con los datos de la compañía a crear
     * @return ResponseEntity con los datos de la compañía creada
     */
    @PostMapping
    public ResponseEntity<CompanyOutDto> create(@Valid @RequestBody CompanyInDto dto) {
        return ResponseEntity.ok(service.createCompany(dto));
    }

    /**
     * Obtiene todas las compañías registradas.
     *
     * @return ResponseEntity con la lista de todas las compañías
     */
    @GetMapping
    public ResponseEntity<List<CompanyOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllCompanies());
    }

    /**
     * Obtiene una compañía específica por su identificador.
     *
     * @param id identificador único de la compañía
     * @return ResponseEntity con los datos de la compañía solicitada
     */
    @GetMapping("/{id}")
    public ResponseEntity<CompanyOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getCompanyById(id));
    }

    /**
     * Actualiza los datos de una compañía existente.
     *
     * @param id  identificador único de la compañía a actualizar
     * @param dto objeto con los nuevos datos de la compañía
     * @return ResponseEntity con los datos actualizados de la compañía
     */
    @PutMapping("/{id}")
    public ResponseEntity<CompanyOutDto> update(@PathVariable Integer id, @Valid @RequestBody CompanyInDto dto) {
        return ResponseEntity.ok(service.updateCompany(id, dto));
    }

    /**
     * Elimina una compañía específica.
     *
     * @param id identificador único de la compañía a eliminar
     * @return ResponseEntity sin contenido, con código de estado 204
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }
}