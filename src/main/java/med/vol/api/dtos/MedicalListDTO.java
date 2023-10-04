package med.vol.api.dtos;

import med.vol.api.entities.Doctor;
import med.vol.api.enums.Specialty;

public record MedicalListDTO(Long id, String name, String email, String crm, Specialty specialty) {

  public MedicalListDTO(Doctor doctor) {
    this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
  }
}
