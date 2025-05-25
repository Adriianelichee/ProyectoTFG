package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.PurchasedServicesService;
import com.adri.proyectotfg.Infrastructure.Dto.In.PurchasedServiceInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.PurchasedServiceOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/purchased-services")
@RequiredArgsConstructor
public class PurchasedServiceController {
    private final PurchasedServicesService service;

    @PostMapping
    public ResponseEntity<PurchasedServiceOutDto> create(@RequestBody PurchasedServiceInDto dto) {
        return ResponseEntity.ok(service.createPurchasedService(dto));
    }

    @GetMapping
    public ResponseEntity<List<PurchasedServiceOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllPurchasedServices());
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<PurchasedServiceOutDto>> getByCompany(@PathVariable Integer companyId) {
        return ResponseEntity.ok(service.getPurchasedServicesByCompany(companyId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchasedServiceOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getPurchasedServiceById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchasedServiceOutDto> update(@PathVariable Integer id, @RequestBody PurchasedServiceInDto dto) {
        return ResponseEntity.ok(service.updatePurchasedService(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deletePurchasedService(id);
        return ResponseEntity.noContent().build();
    }
}
