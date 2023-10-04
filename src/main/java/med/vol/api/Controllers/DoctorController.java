package med.vol.api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.vol.api.Doctors.Doctor;
import med.vol.api.Doctors.DoctorRepository;
import med.vol.api.Doctors.MedicalListDTO;
import med.vol.api.Doctors.MedicalRegistrationData;

@RestController
@RequestMapping("doctors")
public class DoctorController {

  @Autowired // Injeção das dependências
  private DoctorRepository doctorReposity;

  @PostMapping
  @Transactional
  // Pega os parametros do corpo da requisição e aciona o bean validation
  public void create(@RequestBody @Valid MedicalRegistrationData data) {
    doctorReposity.save(new Doctor(data));
  }

  @GetMapping
  public List<MedicalListDTO> list() {
    return doctorReposity.findAll().stream().map(MedicalListDTO::new).toList();
  }
}
