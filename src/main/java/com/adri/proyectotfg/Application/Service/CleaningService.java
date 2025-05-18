package com.adri.proyectotfg.Application.Service;

import com.adri.proyectotfg.Infrastructure.Dto.In.CleaningInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.CleaningOutDto;

import java.util.List;

public interface CleaningService {
    CleaningOutDto createCleaning(CleaningInDto dto);
    CleaningOutDto getCleaningById(Integer id);
    List<CleaningOutDto> getAllCleanings();
    List<CleaningOutDto> getCleaningsByFloor(Integer floorId);
    CleaningOutDto updateCleaning(Integer id, CleaningInDto dto);
    void deleteCleaning(Integer id);
}