package com.adri.proyectotfg.Infrastructure.Dto.In;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailReservationWorkstationInDto {
    private Integer reservationId;
    private Integer workstationId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}