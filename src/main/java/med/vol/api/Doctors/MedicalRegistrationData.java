package med.vol.api.Doctors;

import med.vol.api.Controllers.Address.Address;

public record MedicalRegistrationData(String name, String email, String crm, Specialty specialty, Address address) {

}
