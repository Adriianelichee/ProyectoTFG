package com.adri.proyectotfg.Infrastructure.Dto.In;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceInDto {
    @NotBlank(message = "El nombre del servicio es obligatorio")
    @Size(max = 45, message = "El nombre del servicio no debe exceder 45 caracteres")
    private String serviceName;

    @NotBlank(message = "La descripción es obligatoria")
    private String description;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El precio debe ser mayor que 0")
    private BigDecimal price;
}
