package com.adri.proyectotfg.Infrastructure.Dto.Out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyOutDto {
    private Integer companyId;
    private String companyName;
    private String address;
    private String phone;
    private String contactEmail;
}