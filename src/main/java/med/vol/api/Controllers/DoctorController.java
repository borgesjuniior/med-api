package med.vol.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.vol.api.dtos.MedicalListDTO;
import med.vol.api.dtos.MedicalRegistrationData;
import med.vol.api.dtos.MedicalUpdateDTO;
import med.vol.api.entities.Doctor;
import med.vol.api.repositories.DoctorRepository;

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
  // Seta paginação com alguns parametros padrão, caso não foram passados pelo
  // cliente
  public Page<MedicalListDTO> list(@PageableDefault(size = 10, sort = { "name" }) Pageable pageable) {
    return doctorReposity.findAll(pageable).map(MedicalListDTO::new);
  }

  @PutMapping
  @Transactional
  public void update(@RequestBody @Valid MedicalUpdateDTO data) {
    var doctor = doctorReposity.getReferenceById(data.id());
    doctor.updateInfo(data);
  }

}
