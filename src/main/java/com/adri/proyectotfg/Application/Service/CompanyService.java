package com.adri.proyectotfg.Application.Service;

import com.adri.proyectotfg.Infrastructure.Dto.In.CompanyInDto;
import com.adri.proyectotfg.Infrastructure.Dto.In.RoomInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.CompanyOutDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.RoomOutDto;

import java.util.List;

public interface CompanyService {
    CompanyOutDto createCompany(CompanyInDto dto);
    CompanyOutDto getCompanyById(Integer id);
    List<CompanyOutDto> getAllCompanies();
    CompanyOutDto updateCompany(Integer id, CompanyInDto dto);
    void deleteCompany(Integer id);
}