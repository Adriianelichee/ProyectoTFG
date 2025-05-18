package com.adri.proyectotfg.Infrastructure.Dto.Out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WorkstationOutDto {
    private Integer workstationId;
    private Boolean available;
    private BigDecimal hourlyRate;
    private Integer floorId;
}