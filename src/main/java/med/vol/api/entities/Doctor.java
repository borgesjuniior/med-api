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
import med.vol.api.dtos.MedicalRegistrationData;
import med.vol.api.dtos.MedicalUpdateDTO;
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

  public Doctor(MedicalRegistrationData data) {
    this.name = data.name();
    this.email = data.email();
    this.phone = data.phone();
    this.crm = data.crm();
    this.address = new Address(data.address());
    this.specialty = data.specialty();
  }

  public void updateInfo(MedicalUpdateDTO data) {
    if (data.name() != null) {
      this.name = data.name();
    }

    if (data.phone() != null) {
      this.phone = data.phone();
    }

    if (data.address() != null) {
      this.address.updateAddress(data.address());
    }
  }
}
