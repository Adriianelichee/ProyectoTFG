package com.adri.proyectotfg.Infrastructure.Dto.In;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FloorInDto {
    private String floorName;
    private String description;
}