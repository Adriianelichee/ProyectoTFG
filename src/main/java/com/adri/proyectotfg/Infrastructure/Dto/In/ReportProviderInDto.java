package com.adri.proyectotfg.Infrastructure.Dto.In;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportProviderInDto {
    @NotBlank(message = "El nombre del proveedor es obligatorio")
    @Size(max = 45, message = "El nombre del proveedor no debe exceder 45 caracteres")
    private String providerName;

    @NotBlank(message = "La especialidad es obligatoria")
    private String specialty;

    @NotBlank(message = "El teléfono es obligatorio")
    @Size(max = 20, message = "El teléfono no debe exceder 20 caracteres")
    private String phone;

    @NotBlank(message = "El email de contacto es obligatorio")
    @Email(message = "El email de contacto debe ser válido")
    private String contactEmail;
}

