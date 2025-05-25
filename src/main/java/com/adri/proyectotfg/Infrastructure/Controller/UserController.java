package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.UserService;
import com.adri.proyectotfg.Infrastructure.Dto.In.UserInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.UserOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
class UserController {
    private final UserService service;

    @GetMapping
    public ResponseEntity<List<UserOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getUserById(id));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserOutDto> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(service.getUserByEmail(email));
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<UserOutDto>> getByCompany(@PathVariable Integer companyId) {
        return ResponseEntity.ok(service.getUsersByCompany(companyId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserOutDto> update(@PathVariable Integer id, @RequestBody UserInDto dto) {
        return ResponseEntity.ok(service.updateUser(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
