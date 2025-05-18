package com.adri.proyectotfg.Infrastructure.Dto.Out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOutDto {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String role;
    private Integer companyId;
    private Integer providerId;
}