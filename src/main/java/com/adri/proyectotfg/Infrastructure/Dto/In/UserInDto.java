package com.adri.proyectotfg.Infrastructure.Dto.In;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String role;
    private Integer companyId;
    private Integer providerId;
}