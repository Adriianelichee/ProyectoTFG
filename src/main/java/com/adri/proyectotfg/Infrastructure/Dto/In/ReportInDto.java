package com.adri.proyectotfg.Infrastructure.Dto.In;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportInDto {
    private Integer userId;
    private String description;
    private String status;
    private LocalDateTime reportDate;
    private Integer assignedManagerId;
    private Integer workstationId;
    private Integer roomId;
    private Integer floorId;
}