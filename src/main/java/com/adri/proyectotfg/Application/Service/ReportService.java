package com.adri.proyectotfg.Application.Service;

import com.adri.proyectotfg.Infrastructure.Dto.In.ReportInDto;
import com.adri.proyectotfg.Infrastructure.Dto.In.ReportProviderInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ReportOutDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ReportProviderOutDto;

import java.util.List;

public interface ReportService {
    ReportOutDto createReport(ReportInDto dto);
    ReportOutDto getReportById(Integer id);
    List<ReportOutDto> getAllReports();
    List<ReportOutDto> getReportsByFloor(Integer floorId);
    ReportOutDto updateReport(Integer id, ReportInDto dto);
    void deleteReport(Integer id);
}