package med.vol.api.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.vol.api.dtos.DoctorRegistrationDTO;
import med.vol.api.dtos.DoctorUpdateDTO;
import med.vol.api.enums.Specialty;

@Entity(name = "doctors")
@Table(name = "doctors")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String phone;
  private String email;
  private String crm;

  @Enumerated(EnumType.STRING)
  private Specialty specialty;

  @Embedded
  private Address address;

  public Doctor(DoctorRegistrationDTO data) {
    this.name = data.name();
    this.email = data.email();
    this.phone = data.phone();
    this.crm = data.crm();
    this.address = new Address(data.address());
    this.specialty = data.specialty();
  }

  public void updateInfo(DoctorUpdateDTO doctor) {
    if (doctor.name() != null) {
      this.name = doctor.name();
    }

    if (doctor.phone() != null) {
      this.phone = doctor.phone();
    }

    if (doctor.address() != null) {
      this.address.updateAddress(doctor.address());
    }
  }
}
