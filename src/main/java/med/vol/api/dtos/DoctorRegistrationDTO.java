package med.vol.api.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.vol.api.enums.Specialty;

public record DoctorRegistrationDTO(
                @NotBlank String name,
                @NotBlank @Email String email,
                @NotBlank String phone,
                @NotBlank @Pattern(regexp = "\\d{4,6}") String crm,
                @NotNull Specialty specialty,
                @NotNull @Valid AddressDTO address) {
}

// o Record é um recurso que permite representar uma classe imutável, contendo
// apenas atributos, construtor e métodos de leitura, de uma maneira muito
// simples e enxuta
