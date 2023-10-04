package med.vol.api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.vol.api.Doctors.Doctor;
import med.vol.api.Doctors.DoctorRepository;
import med.vol.api.Doctors.MedicalRegistrationData;

@RestController
@RequestMapping("doctors")
public class DoctorController {

  @Autowired // Injeção das dependências
  private DoctorRepository doctorReposity;

  @PostMapping
  @Transactional
  public void create(@RequestBody @Valid MedicalRegistrationData data) { // Get request body
    doctorReposity.save(new Doctor(data));
  }
}
