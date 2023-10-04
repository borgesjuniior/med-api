package med.vol.api.Doctors;

public record MedicalListDTO(String name, String email, String crm, Specialty specialty) {

  public MedicalListDTO(Doctor doctor) {
    this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
  }
}
