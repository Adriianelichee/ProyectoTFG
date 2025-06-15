package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.UserService;
import com.adri.proyectotfg.Infrastructure.Dto.In.UserInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.UserOutDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que gestiona las operaciones relacionadas con los usuarios.
 * Proporciona endpoints para consultar, actualizar y eliminar usuarios,
 * así como para filtrarlos por email o compañía.
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
class UserController {
    private final UserService service;

    /**
     * Obtiene todos los usuarios registrados en el sistema.
     *
     * @return ResponseEntity con la lista de todos los usuarios
     */
    @GetMapping
    public ResponseEntity<List<UserOutDto>> getAll() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    /**
     * Obtiene un usuario específico por su identificador.
     *
     * @param id identificador único del usuario
     * @return ResponseEntity con los datos del usuario solicitado
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserOutDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getUserById(id));
    }

    /**
     * Obtiene un usuario específico por su dirección de correo electrónico.
     *
     * @param email dirección de correo electrónico del usuario
     * @return ResponseEntity con los datos del usuario solicitado
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<UserOutDto> getByEmail(@PathVariable String email) {
        return ResponseEntity.ok(service.getUserByEmail(email));
    }

    /**
     * Obtiene todos los usuarios asociados a una compañía específica.
     *
     * @param companyId identificador único de la compañía
     * @return ResponseEntity con la lista de usuarios de la compañía especificada
     */
    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<UserOutDto>> getByCompany(@PathVariable Integer companyId) {
        return ResponseEntity.ok(service.getUsersByCompany(companyId));
    }

    /**
     * Actualiza los datos de un usuario existente.
     *
     * @param id  identificador único del usuario a actualizar
     * @param dto objeto con los nuevos datos del usuario
     * @return ResponseEntity con los datos actualizados del usuario
     */
    @PutMapping("/{id}")
    public ResponseEntity<UserOutDto> update(@PathVariable Integer id, @Valid @RequestBody UserInDto dto) {
        return ResponseEntity.ok(service.updateUser(id, dto));
    }

    /**
     * Elimina un usuario específico del sistema.
     *
     * @param id identificador único del usuario a eliminar
     * @return ResponseEntity sin contenido, con código de estado 204
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}