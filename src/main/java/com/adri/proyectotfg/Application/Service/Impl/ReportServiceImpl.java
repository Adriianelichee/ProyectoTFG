package com.adri.proyectotfg.Application.Service.Impl;

import com.adri.proyectotfg.Application.Mapper.ReportMapper;
import com.adri.proyectotfg.Application.Service.ReportService;
import com.adri.proyectotfg.Domain.Entity.Report;
import com.adri.proyectotfg.Domain.Entity.ReportStatus;
import com.adri.proyectotfg.Domain.Repository.ReportRepository;
import com.adri.proyectotfg.Infrastructure.Dto.In.ReportInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ReportOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportServiceImpl implements ReportService {
    private final ReportRepository repository;
    private final ReportMapper mapper;

    @Override
    public ReportOutDto createReport(ReportInDto dto) {
        Report r = mapper.toEntity(dto);
        return mapper.toDto(repository.save(r));
    }

    @Override
    public ReportOutDto getReportById(Integer id) {
        Report r = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found: " + id));
        return mapper.toDto(r);
    }

    @Override
    public ReportOutDto updateReportStatus(Integer id, String status) {
        Report report = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado con id: " + id));

        try {
            ReportStatus reportStatus = ReportStatus.valueOf(status);
            report.setStatus(reportStatus);
            return mapper.toDto(repository.save(report));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Estado de reporte no válido: " + status);
        }
    }

    @Override
    public List<ReportOutDto> getAllReports() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReportOutDto> getReportsByFloor(Integer floorId) {
        return repository.findByFloorId(floorId).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReportOutDto updateReport(Integer id, ReportInDto dto) {
        Report r = mapper.toEntity(dto);
        r.setReportId(id);
        return mapper.toDto(repository.save(r));
    }

    @Override
    public void deleteReport(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<ReportOutDto> getReportsByUserId(Integer userId) {
        return repository.findByUserId(userId).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

}
