package com.adri.proyectotfg.Application.Service.Impl;

import com.adri.proyectotfg.Domain.Entity.User;
import com.adri.proyectotfg.Infrastructure.Repository.Jpa.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserJpaRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Intentando autenticar usuario con email: " + email);

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> {
                    System.out.println("Usuario no encontrado con email: " + email);
                    return new UsernameNotFoundException("Usuario no encontrado con email: " + email);
                });

        System.out.println("Usuario encontrado: " + user.getEmail());
        System.out.println("Contraseña almacenada (hash): " + user.getPassword());

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()))
        );
    }
}