package med.vol.api.Address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    this.number = address.number();
  }
}
