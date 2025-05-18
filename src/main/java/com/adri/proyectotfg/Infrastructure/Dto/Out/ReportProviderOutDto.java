package com.adri.proyectotfg.Infrastructure.Dto.Out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportProviderOutDto {
    private Integer providerId;
    private String providerName;
    private String specialty;
    private String phone;
    private String contactEmail;
}