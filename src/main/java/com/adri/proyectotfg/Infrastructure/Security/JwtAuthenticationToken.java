package com.adri.proyectotfg.Infrastructure.Security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collection;

public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {
    public JwtAuthenticationToken(Object principal, Object credentials, Collection authorities) {
        super(principal, credentials, authorities);
    }
}