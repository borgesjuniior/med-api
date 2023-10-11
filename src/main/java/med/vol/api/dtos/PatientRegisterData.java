package med.vol.api.dtos;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PatientRegisterData(
                @NotBlank String name,
                @NotBlank @Email String email,
                @NotBlank @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}") String cpf,
                @NotNull @Valid AddressDTO address) {
}
