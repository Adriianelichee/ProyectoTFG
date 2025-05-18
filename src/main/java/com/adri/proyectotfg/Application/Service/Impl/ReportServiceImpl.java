package com.adri.proyectotfg.Application.Service.Impl;

import com.adri.proyectotfg.Application.Mapper.ReportMapper;
import com.adri.proyectotfg.Application.Service.ReportService;
import com.adri.proyectotfg.Domain.Entity.Report;
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
}
