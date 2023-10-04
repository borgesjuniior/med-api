package med.vol.api.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.vol.api.dtos.AddressDTO;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
  private String street;
  private String neighborhood;
  private String city;
  private String number;

  public Address(AddressDTO address) {
    this.street = address.street();
    this.neighborhood = address.neighborhood();
    this.city = address.city();
  }

  public void updateAddress(AddressDTO address) {
    if (address.street() != null) {
      this.city = address.street();
    }

    if (address.neighborhood() != null) {
      this.city = address.neighborhood();
    }

    if (address.city() != null) {
      this.city = address.city();
    }
  }
}
