package com.adri.proyectotfg.Infrastructure.Dto.In;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInDto {
    private Integer companyId;
    private BigDecimal amount;
    private String paymentType;
    private String paymentMethod;
    private LocalDateTime paymentDate;
    private String paymentStatus;
}
