package com.adri.proyectotfg.Infrastructure.Dto.In;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyInDto {
    @NotBlank(message = "El nombre de la empresa es obligatorio")
    @Size(max = 45, message = "El nombre de la empresa no debe exceder 45 caracteres")
    private String companyName;

    @NotBlank(message = "La dirección es obligatoria")
    @Size(max = 100, message = "La dirección no debe exceder 100 caracteres")
    private String address;

    @NotBlank(message = "El teléfono es obligatorio")
    @Size(max = 20, message = "El teléfono no debe exceder 20 caracteres")
    private String phone;

    @NotBlank(message = "El email de contacto es obligatorio")
    @Email(message = "El email de contacto debe ser válido")
    private String contactEmail;
}

