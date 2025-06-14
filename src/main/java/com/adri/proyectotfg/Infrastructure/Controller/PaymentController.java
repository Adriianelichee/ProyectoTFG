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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService service;

    @PostMapping
    public ResponseEntity<PaymentOutDto> create(@Valid @RequestBody PaymentInDto dto) {
        return ResponseEntity.ok(service.createPayment(dto));
    }

    @GetMapping
    public ResponseEntity<List<PaymentOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllPayments());
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<PaymentOutDto>> getByCompany(@PathVariable Integer companyId) {
        return ResponseEntity.ok(service.getPaymentsByCompany(companyId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getPaymentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentOutDto> update(@PathVariable Integer id,@Valid @RequestBody PaymentInDto dto) {
        return ResponseEntity.ok(service.updatePayment(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deletePayment(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<PaymentOutDto> updateStatus(@PathVariable Integer id, @RequestBody Map<String, String> statusMap) {
        String newStatus = statusMap.get("status");
        if (newStatus == null) {
            throw new IllegalArgumentException("El campo 'status' es requerido");
        }
        return ResponseEntity.ok(service.updatePaymentStatus(id, newStatus));
    }

}