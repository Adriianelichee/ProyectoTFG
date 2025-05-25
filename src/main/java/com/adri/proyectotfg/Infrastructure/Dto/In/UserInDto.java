package com.adri.proyectotfg.Infrastructure.Dto.In;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInDto {
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 45, message = "El nombre no debe exceder 45 caracteres")
    private String firstName;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 45, message = "El apellido no debe exceder 45 caracteres")
    private String lastName;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email debe ser válido")
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password;

    @NotBlank(message = "El teléfono es obligatorio")
    @Size(max = 20, message = "El teléfono no debe exceder 20 caracteres")
    private String phone;

    @NotBlank(message = "El rol es obligatorio")
    private String role;

    @NotNull(message = "El ID de empresa es obligatorio")
    private Integer companyId;

    private Integer providerId;
}