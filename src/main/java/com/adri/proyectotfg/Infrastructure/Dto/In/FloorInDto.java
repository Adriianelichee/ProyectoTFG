package com.adri.proyectotfg.Infrastructure.Dto.In;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class FloorInDto {
    @NotBlank(message = "El nombre del piso es obligatorio")
    @Size(max = 45, message = "El nombre del piso no debe exceder 45 caracteres")
    private String floorName;

    @NotBlank(message = "La descripción es obligatoria")
    private String description;
}
