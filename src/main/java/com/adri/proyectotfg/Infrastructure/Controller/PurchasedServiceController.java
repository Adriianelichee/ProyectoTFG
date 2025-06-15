package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.PurchasedServicesService;
import com.adri.proyectotfg.Infrastructure.Dto.In.PurchasedServiceInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.PurchasedServiceOutDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que gestiona las operaciones relacionadas con los servicios adquiridos.
 * Proporciona endpoints para crear, consultar, actualizar y eliminar servicios adquiridos,
 * así como para filtrarlos por empresa.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/purchased-services")
@RequiredArgsConstructor
public class PurchasedServiceController {
    private final PurchasedServicesService service;

    /**
     * Crea un nuevo servicio adquirido en el sistema.
     *
     * @param dto objeto con los datos del servicio adquirido a crear
     * @return ResponseEntity con los datos del servicio adquirido creado
     */
    @PostMapping
    public ResponseEntity<PurchasedServiceOutDto> create(@Valid @RequestBody PurchasedServiceInDto dto) {
        return ResponseEntity.ok(service.createPurchasedService(dto));
    }

    /**
     * Obtiene todos los servicios adquiridos registrados en el sistema.
     *
     * @return ResponseEntity con la lista de todos los servicios adquiridos
     */
    @GetMapping
    public ResponseEntity<List<PurchasedServiceOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllPurchasedServices());
    }

    /**
     * Obtiene todos los servicios adquiridos asociados a una empresa específica.
     *
     * @param companyId identificador único de la empresa
     * @return ResponseEntity con la lista de servicios adquiridos de la empresa especificada
     */
    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<PurchasedServiceOutDto>> getByCompany(@PathVariable Integer companyId) {
        return ResponseEntity.ok(service.getPurchasedServicesByCompany(companyId));
    }

    /**
     * Obtiene un servicio adquirido específico por su identificador.
     *
     * @param id identificador único del servicio adquirido
     * @return ResponseEntity con los datos del servicio adquirido solicitado
     */
    @GetMapping("/{id}")
    public ResponseEntity<PurchasedServiceOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getPurchasedServiceById(id));
    }

    /**
     * Actualiza los datos de un servicio adquirido existente.
     *
     * @param id  identificador único del servicio adquirido a actualizar
     * @param dto objeto con los nuevos datos del servicio adquirido
     * @return ResponseEntity con los datos actualizados del servicio adquirido
     */
    @PutMapping("/{id}")
    public ResponseEntity<PurchasedServiceOutDto> update(@PathVariable Integer id, @Valid @RequestBody PurchasedServiceInDto dto) {
        return ResponseEntity.ok(service.updatePurchasedService(id, dto));
    }

    /**
     * Elimina un servicio adquirido específico del sistema.
     *
     * @param id identificador único del servicio adquirido a eliminar
     * @return ResponseEntity sin contenido, con código de estado 204
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deletePurchasedService(id);
        return ResponseEntity.noContent().build();
    }
}