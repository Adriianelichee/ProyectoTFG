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
public class ReservationInDto {
    @NotNull(message = "El ID de usuario es obligatorio")
    private Integer userId;

    @NotBlank(message = "El tipo de reserva es obligatorio")
    private String reservationType;

    @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDateTime startDate;

    @NotNull(message = "La fecha de fin es obligatoria")
    private LocalDateTime endDate;

    @NotBlank(message = "El estado de reserva es obligatorio")
    private String status;

    private Integer depositPaymentId;
}