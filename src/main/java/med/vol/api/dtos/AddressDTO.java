package med.vol.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record AddressDTO(
        @NotBlank String street,
        @NotBlank String neighborhood,
        @NotBlank String city,
        String number) {
}
