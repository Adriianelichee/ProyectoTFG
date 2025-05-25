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
public class CleaningInDto {
    @NotNull(message = "El ID de usuario es obligatorio")
    private Integer userId;

    @NotNull(message = "La fecha de limpieza es obligatoria")
    private LocalDateTime cleaningDate;

    private String notes;

    private Integer roomId;
    private Integer workstationId;

    @NotNull(message = "El ID de piso es obligatorio")
    private Integer floorId;
}