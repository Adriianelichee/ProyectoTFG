package com.adri.proyectotfg.Infrastructure.Dto.In;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
