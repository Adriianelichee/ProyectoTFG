package com.adri.proyectotfg.Infrastructure.Dto.Out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationOutDto {
    private Integer reservationId;
    private Integer userId;
    private String reservationType;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;
    private Integer depositPaymentId;
}