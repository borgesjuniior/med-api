package med.vol.api.dtos;

import med.vol.api.entities.Address;
import med.vol.api.entities.Doctor;
import med.vol.api.enums.Specialty;

public record DoctorDetails(Long id, String name, String email, String phone, String crm, Specialty specialty,
    Address address) {

  public DoctorDetails(Doctor doctor) {
    this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getPhone(), doctor.getCrm(), doctor.getSpecialty(),
        doctor.getAddress());
  }
}
