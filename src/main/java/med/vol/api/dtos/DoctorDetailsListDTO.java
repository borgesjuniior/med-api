package med.vol.api.dtos;

import med.vol.api.entities.Doctor;
import med.vol.api.enums.Specialty;

public record DoctorDetailsListDTO(Long id, String name, String email, String crm, Specialty specialty) {

  public DoctorDetailsListDTO(Doctor doctor) {
    this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
  }
}
