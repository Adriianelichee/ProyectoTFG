package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.PaymentService;
import com.adri.proyectotfg.Infrastructure.Dto.In.PaymentInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.PaymentOutDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Controlador REST que gestiona las operaciones relacionadas con los pagos.
 * Proporciona endpoints para crear, consultar, actualizar y eliminar pagos,
 * así como para actualizar el estado de los mismos y filtrarlos por empresa.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService service;

    /**
     * Crea un nuevo pago en el sistema.
     *
     * @param dto objeto con los datos del pago a crear
     * @return ResponseEntity con los datos del pago creado
     */
    @PostMapping
    public ResponseEntity<PaymentOutDto> create(@Valid @RequestBody PaymentInDto dto) {
        return ResponseEntity.ok(service.createPayment(dto));
    }

    /**
     * Obtiene todos los pagos registrados en el sistema.
     *
     * @return ResponseEntity con la lista de todos los pagos
     */
    @GetMapping
    public ResponseEntity<List<PaymentOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllPayments());
    }

    /**
     * Obtiene todos los pagos asociados a una empresa específica.
     *
     * @param companyId identificador único de la empresa
     * @return ResponseEntity con la lista de pagos de la empresa especificada
     */
    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<PaymentOutDto>> getByCompany(@PathVariable Integer companyId) {
        return ResponseEntity.ok(service.getPaymentsByCompany(companyId));
    }

    /**
     * Obtiene un pago específico por su identificador.
     *
     * @param id identificador único del pago
     * @return ResponseEntity con los datos del pago solicitado
     */
    @GetMapping("/{id}")
    public ResponseEntity<PaymentOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getPaymentById(id));
    }

    /**
     * Actualiza los datos de un pago existente.
     *
     * @param id  identificador único del pago a actualizar
     * @param dto objeto con los nuevos datos del pago
     * @return ResponseEntity con los datos actualizados del pago
     */
    @PutMapping("/{id}")
    public ResponseEntity<PaymentOutDto> update(@PathVariable Integer id, @Valid @RequestBody PaymentInDto dto) {
        return ResponseEntity.ok(service.updatePayment(id, dto));
    }

    /**
     * Elimina un pago específico del sistema.
     *
     * @param id identificador único del pago a eliminar
     * @return ResponseEntity sin contenido, con código de estado 204
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deletePayment(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Actualiza únicamente el estado de un pago existente.
     *
     * @param id        identificador único del pago cuyo estado se va a actualizar
     * @param statusMap objeto con el nuevo estado del pago
     * @return ResponseEntity con los datos actualizados del pago
     * @throws IllegalArgumentException si no se proporciona el campo 'status' en el cuerpo de la solicitud
     */
    @PatchMapping("/{id}/status")
    public ResponseEntity<PaymentOutDto> updateStatus(@PathVariable Integer id, @RequestBody Map<String, String> statusMap) {
        String newStatus = statusMap.get("status");
        if (newStatus == null) {
            throw new IllegalArgumentException("El campo 'status' es requerido");
        }
        return ResponseEntity.ok(service.updatePaymentStatus(id, newStatus));
    }
}