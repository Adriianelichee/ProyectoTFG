package com.adri.proyectotfg.Application.Service;

import com.adri.proyectotfg.Infrastructure.Dto.In.ServiceInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ServiceOutDto;

import java.util.List;

public interface ServicesService {
    ServiceOutDto createService(ServiceInDto dto);
    ServiceOutDto getServiceById(Integer id);
    List<ServiceOutDto> getAllServices();
    ServiceOutDto updateService(Integer id, ServiceInDto dto);
    void deleteService(Integer id);
}