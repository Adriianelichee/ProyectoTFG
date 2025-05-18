package com.adri.proyectotfg.Application.Service;

import com.adri.proyectotfg.Infrastructure.Dto.In.PurchasedServiceInDto;
import com.adri.proyectotfg.Infrastructure.Dto.In.ServiceInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.PurchasedServiceOutDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ServiceOutDto;

import java.util.List;

public interface PurchasedServicesService {
    PurchasedServiceOutDto createPurchasedService(PurchasedServiceInDto dto);
    PurchasedServiceOutDto getPurchasedServiceById(Integer id);
    List<PurchasedServiceOutDto> getAllPurchasedServices();
    List<PurchasedServiceOutDto> getPurchasedServicesByCompany(Integer companyId);
    PurchasedServiceOutDto updatePurchasedService(Integer id, PurchasedServiceInDto dto);
    void deletePurchasedService(Integer id);
}