package com.adri.proyectotfg.Infrastructure.Dto.In;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportProviderInDto {
    private String providerName;
    private String specialty;
    private String phone;
    private String contactEmail;
}
