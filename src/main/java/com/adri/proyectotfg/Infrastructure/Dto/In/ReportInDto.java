package com.adri.proyectotfg.Infrastructure.Dto.In;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportInDto {
    @NotNull(message = "El ID de usuario es obligatorio")
    private Integer userId;

    @NotBlank(message = "La descripción es obligatoria")
    private String description;

    @NotBlank(message = "El estado es obligatorio")
    private String status;

    @NotNull(message = "La fecha de reporte es obligatoria")
    private LocalDateTime reportDate;

    @NotNull(message = "El ID del gestor asignado es obligatorio")
    private Integer assignedManagerId;

    private Integer workstationId;
    private Integer roomId;

    @NotNull(message = "El ID de piso es obligatorio")
    private Integer floorId;
}
