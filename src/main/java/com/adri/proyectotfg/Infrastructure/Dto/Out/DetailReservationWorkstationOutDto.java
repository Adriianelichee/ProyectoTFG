package com.adri.proyectotfg.Infrastructure.Dto.Out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailReservationWorkstationOutDto {
    private Integer detailId;
    private Integer reservationId;
    private Integer workstationId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}