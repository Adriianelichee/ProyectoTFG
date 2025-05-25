package com.adri.proyectotfg.Infrastructure.Dto.In;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkstationInDto {
    @NotNull(message = "El estado de disponibilidad es obligatorio")
    private Boolean available;

    @NotNull(message = "El precio por hora es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio por hora debe ser mayor que 0")
    private BigDecimal hourlyRate;

    @NotNull(message = "El ID de piso es obligatorio")
    private Integer floorId;
}