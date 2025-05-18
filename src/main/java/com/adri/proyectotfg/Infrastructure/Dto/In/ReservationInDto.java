package com.adri.proyectotfg.Infrastructure.Dto.In;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationInDto {
    private Integer userId;
    private String reservationType;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String status;
    private Integer depositPaymentId;
}