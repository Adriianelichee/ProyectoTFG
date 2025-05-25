package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.CompanyService;
import com.adri.proyectotfg.Infrastructure.Dto.In.CompanyInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.CompanyOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/companies")
@RequiredArgsConstructor
class CompanyController {
    private final CompanyService service;

    @PostMapping
    public ResponseEntity<CompanyOutDto> create(@RequestBody CompanyInDto dto) {
        return ResponseEntity.ok(service.createCompany(dto));
    }

    @GetMapping
    public ResponseEntity<List<CompanyOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllCompanies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getCompanyById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyOutDto> update(@PathVariable Integer id, @RequestBody CompanyInDto dto) {
        return ResponseEntity.ok(service.updateCompany(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }
}