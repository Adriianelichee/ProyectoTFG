package com.adri.proyectotfg.Application.Service;

import com.adri.proyectotfg.Infrastructure.Dto.In.ReportProviderInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ReportProviderOutDto;

import java.util.List;

public interface ReportProviderService {
    ReportProviderOutDto createProvider(ReportProviderInDto dto);
    ReportProviderOutDto getProviderById(Integer id);
    List<ReportProviderOutDto> getAllProviders();
    ReportProviderOutDto updateProvider(Integer id, ReportProviderInDto dto);
    void deleteProvider(Integer id);
}