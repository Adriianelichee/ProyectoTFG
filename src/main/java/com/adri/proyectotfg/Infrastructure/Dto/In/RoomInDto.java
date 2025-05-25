package com.adri.proyectotfg.Infrastructure.Dto.In;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomInDto {
    @NotBlank(message = "El nombre de la sala es obligatorio")
    @Size(max = 45, message = "El nombre de la sala no debe exceder 45 caracteres")
    private String roomName;

    @NotNull(message = "La capacidad es obligatoria")
    @Min(value = 1, message = "La capacidad mínima es 1")
    private Integer capacity;

    @NotNull(message = "El precio por hora es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio por hora debe ser mayor que 0")
    private BigDecimal hourlyRate;

    @NotNull(message = "El estado de disponibilidad es obligatorio")
    private Boolean available;

    @NotNull(message = "El ID de piso es obligatorio")
    private Integer floorId;
}