package com.adri.proyectotfg.Infrastructure.Dto.Out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CleaningOutDto {
    private Integer cleaningId;
    private Integer userId;
    private LocalDateTime cleaningDate;
    private String notes;
    private Integer roomId;
    private Integer workstationId;
    private Integer floorId;
}