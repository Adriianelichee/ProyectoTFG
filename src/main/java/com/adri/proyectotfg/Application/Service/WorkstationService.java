package com.adri.proyectotfg.Application.Service;

import com.adri.proyectotfg.Infrastructure.Dto.In.UserInDto;
import com.adri.proyectotfg.Infrastructure.Dto.In.WorkstationInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.UserOutDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.WorkstationOutDto;

import java.util.List;

public interface WorkstationService {
    WorkstationOutDto createWorkstation(WorkstationInDto dto);
    WorkstationOutDto getWorkstationById(Integer id);
    List<WorkstationOutDto> getAllWorkstations();
    List<WorkstationOutDto> getWorkstationsByFloor(Integer floorId);
    WorkstationOutDto updateWorkstation(Integer id, WorkstationInDto dto);
    void deleteWorkstation(Integer id);
}