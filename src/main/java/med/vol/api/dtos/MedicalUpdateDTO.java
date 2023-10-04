package med.vol.api.dtos;

import jakarta.validation.constraints.NotNull;

public record MedicalUpdateDTO(
    @NotNull Long id,
    String name,
    String phone,
    AddressDTO address) {

}
