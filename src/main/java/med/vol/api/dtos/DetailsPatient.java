package med.vol.api.dtos;

import med.vol.api.entities.Address;
import med.vol.api.entities.Patient;

public record DetailsPatient(Long id, String name, String email, String cpf,
        Address endereco) {

    public DetailsPatient(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf(),
                patient.getAddress());
    }
}
