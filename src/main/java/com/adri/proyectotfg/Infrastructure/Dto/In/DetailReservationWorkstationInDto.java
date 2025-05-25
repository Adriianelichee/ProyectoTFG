package com.adri.proyectotfg.Infrastructure.Dto.In;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailReservationWorkstationInDto {
    @NotNull(message = "El ID de reserva es obligatorio")
    private Integer reservationId;

    @NotNull(message = "El ID de estación es obligatorio")
    private Integer workstationId;

    @NotNull(message = "La hora de inicio es obligatoria")
    private LocalDateTime startTime;

    @NotNull(message = "La hora de fin es obligatoria")
    private LocalDateTime endTime;
}