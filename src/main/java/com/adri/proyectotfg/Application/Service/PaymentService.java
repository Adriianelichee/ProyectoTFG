package com.adri.proyectotfg.Application.Service;

import com.adri.proyectotfg.Infrastructure.Dto.In.PaymentInDto;
import com.adri.proyectotfg.Infrastructure.Dto.In.ReservationInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.PaymentOutDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.ReservationOutDto;

import java.util.List;

public interface PaymentService {
    PaymentOutDto createPayment(PaymentInDto dto);
    PaymentOutDto getPaymentById(Integer id);
    List<PaymentOutDto> getAllPayments();
    List<PaymentOutDto> getPaymentsByCompany(Integer companyId);
    PaymentOutDto updatePayment(Integer id, PaymentInDto dto);
    void deletePayment(Integer id);
    PaymentOutDto updatePaymentStatus(Integer id, String newStatus);
}