package com.adri.proyectotfg.Infrastructure.Dto.In;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInDto {
    @NotNull(message = "El ID de empresa es obligatorio")
    private Integer companyId;

    @NotNull(message = "El monto es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false, message = "El monto debe ser mayor que 0")
    private BigDecimal amount;

    @NotBlank(message = "El tipo de pago es obligatorio")
    private String paymentType;

    @NotBlank(message = "El método de pago es obligatorio")
    private String paymentMethod;

    @NotNull(message = "La fecha de pago es obligatoria")
    private LocalDateTime paymentDate;

    @NotBlank(message = "El estado de pago es obligatorio")
    private String paymentStatus;
}