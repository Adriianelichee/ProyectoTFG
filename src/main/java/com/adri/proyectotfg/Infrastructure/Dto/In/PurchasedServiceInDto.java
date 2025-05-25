package com.adri.proyectotfg.Infrastructure.Dto.In;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchasedServiceInDto {
    @NotNull(message = "La fecha de compra es obligatoria")
    private LocalDateTime purchaseDate;

    private LocalDateTime expirationDate;

    @NotNull(message = "El ID de empresa es obligatorio")
    private Integer companyId;

    @NotNull(message = "El ID del servicio es obligatorio")
    private Integer serviceId;
}