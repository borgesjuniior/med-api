package med.vol.api.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.vol.api.Doctors.MedicalRegistrationData;

@RestController
@RequestMapping("doctors")
public class DoctorController {

  @PostMapping
  public void create(@RequestBody MedicalRegistrationData data) { // Get request body
    System.out.println(data);
  }
}
