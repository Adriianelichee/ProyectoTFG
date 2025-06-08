package com.adri.proyectotfg.Application.Service;

import com.adri.proyectotfg.Infrastructure.Dto.In.FloorInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.FloorOutDto;

import java.util.List;

public interface FloorService {
    FloorOutDto createFloor(FloorInDto dto);
    FloorOutDto getFloorById(Integer id);
    List<FloorOutDto> getAllFloors();
    FloorOutDto updateFloor(Integer id, FloorInDto dto);
    void deleteFloor(Integer id);
    List<FloorOutDto> getFloorsByCompanyId(Integer companyId);
}