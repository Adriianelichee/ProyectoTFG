package com.adri.proyectotfg.Application.Service.Impl;

import com.adri.proyectotfg.Application.Mapper.PaymentMapper;
import com.adri.proyectotfg.Application.Service.PaymentService;
import com.adri.proyectotfg.Domain.Entity.Payment;
import com.adri.proyectotfg.Domain.Repository.PaymentRepository;
import com.adri.proyectotfg.Infrastructure.Dto.In.PaymentInDto;
import com.adri.proyectotfg.Infrastructure.Dto.Out.PaymentOutDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository repository;
    private final PaymentMapper mapper;

    @Override
    public PaymentOutDto createPayment(PaymentInDto dto) {
        Payment p = mapper.toEntity(dto);
        return mapper.toDto(repository.save(p));
    }

    @Override
    public PaymentOutDto getPaymentById(Integer id) {
        Payment p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found: " + id));
        return mapper.toDto(p);
    }

    @Override
    public List<PaymentOutDto> getAllPayments() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PaymentOutDto> getPaymentsByCompany(Integer companyId) {
        return repository.findByCompanyId(companyId).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentOutDto updatePayment(Integer id, PaymentInDto dto) {
        Payment p = mapper.toEntity(dto);
        p.setPaymentId(id);
        return mapper.toDto(repository.save(p));
    }

    @Override
    public void deletePayment(Integer id) {
        repository.deleteById(id);
    }
}