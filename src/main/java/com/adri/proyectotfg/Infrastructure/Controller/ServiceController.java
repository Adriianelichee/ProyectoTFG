package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.ServicesService;
import com.adri.proyectotfg.Infrastructure.Dto.In.ServiceInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ServiceOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class ServiceController {
    private final ServicesService service;

    @PostMapping
    public ResponseEntity<ServiceOutDto> create(@RequestBody ServiceInDto dto) {
        return ResponseEntity.ok(service.createService(dto));
    }

    @GetMapping
    public ResponseEntity<List<ServiceOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllServices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getServiceById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceOutDto> update(@PathVariable Integer id, @RequestBody ServiceInDto dto) {
        return ResponseEntity.ok(service.updateService(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}
