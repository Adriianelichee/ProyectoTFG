package com.adri.proyectotfg.Infrastructure.Dto.Out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchasedServiceOutDto {
    private Integer purchasedServiceId;
    private LocalDateTime purchaseDate;
    private LocalDateTime expirationDate;
    private Integer companyId;
    private Integer serviceId;
}