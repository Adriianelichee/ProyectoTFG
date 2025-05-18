package com.adri.proyectotfg.Infrastructure.Dto.Out;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomOutDto {
    private Integer roomId;
    private String roomName;
    private Integer capacity;
    private BigDecimal hourlyRate;
    private Boolean available;
    private Integer floorId;
}