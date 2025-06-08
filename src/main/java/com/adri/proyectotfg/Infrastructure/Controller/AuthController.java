package com.adri.proyectotfg.Infrastructure.Controller;

import com.adri.proyectotfg.Application.Service.UserService;
import com.adri.proyectotfg.Domain.Entity.User;
import com.adri.proyectotfg.Domain.Repository.UserRepository;
import com.adri.proyectotfg.Infrastructure.Dto.In.LoginRequest;
import com.adri.proyectotfg.Infrastructure.Dto.In.UserInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.JwtResponse;
import com.adri.proyectotfg.Infrastructure.Dto.Out.UserOutDto;
import com.adri.proyectotfg.Infrastructure.Security.JwtTokenProvider;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authManager;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtProvider;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@Valid @RequestBody LoginRequest request) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        String token = jwtProvider.generateToken(auth);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestParam String email, @RequestParam String newPassword) {
        try {
            User user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado con email: " + email));

            String encodedPassword = passwordEncoder.encode(newPassword);
            user.setPassword(encodedPassword);
            userRepository.save(user);

            return ResponseEntity.ok(Map.of(
                    "message", "Contraseña actualizada con éxito",
                    "email", email,
                    "newPassword", newPassword,
                    "encodedPassword", encodedPassword
            ));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of(
                    "error", "Error al actualizar contraseña",
                    "message", e.getMessage()
            ));
        }
    }

    @PostMapping("/register")
    public ResponseEntity<UserOutDto> register(@Valid @RequestBody UserInDto dto) {
        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        UserOutDto created = userService.createUser(dto);
        return ResponseEntity.ok(created);
    }
}
