package com.adri.proyectotfg.Infrastructure.Security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserDetailsService userDetailsService;

    /**
     * Realiza el filtrado interno para cada solicitud.
     * Este método extrae el token JWT de la solicitud, lo valida y configura
     * el contexto de seguridad si el token es válido. Omite la validación del token
     * para ciertos endpoints de la API.
     *
     * @param request     La solicitud HTTP servlet.
     * @param response    La respuesta HTTP servlet.
     * @param filterChain La cadena de filtros para ejecutar otros filtros.
     * @throws ServletException Si ocurre un error específico del servlet.
     * @throws IOException      Si ocurre un error de E/S durante el procesamiento de este filtro.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);
            if (jwtTokenProvider.validateToken(token)) {
                String username = jwtTokenProvider.getUsernameFromToken(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                JwtAuthenticationToken auth = new JwtAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        filterChain.doFilter(request, response);
    }

    /**
     * Extrae el token JWT del encabezado de Autorización de la solicitud HTTP.
     *
     * @param request El objeto HttpServletRequest que contiene la información de la solicitud HTTP.
     * @return El token JWT extraído como una cadena, o null si no se encuentra un token válido.
     *         El token se extrae eliminando el prefijo "Bearer " del encabezado de Autorización.
     */
    private String extractToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasLength(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}
