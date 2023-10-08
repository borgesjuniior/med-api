package med.vol.api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;
import med.vol.api.dtos.DoctorDetailsListDTO;
import med.vol.api.dtos.DoctorDetails;
import med.vol.api.dtos.DoctorRegistrationDTO;
import med.vol.api.dtos.DoctorUpdateDTO;
import med.vol.api.entities.Doctor;
import med.vol.api.repositories.DoctorRepository;

@RestController
@RequestMapping("doctors")
public class DoctorController {

  @Autowired
  private DoctorRepository doctorReposity;

  @PostMapping
  @Transactional
  public ResponseEntity<DoctorDetails> create(@RequestBody @Valid DoctorRegistrationDTO data,
      UriComponentsBuilder ruiBuidler) {
    var doctor = new Doctor(data);
    doctorReposity.save(doctor);
    var URI = ruiBuidler.path("/doctor/{id}").buildAndExpand(doctor.getId()).toUri();

    return ResponseEntity.created(URI).body(new DoctorDetails(doctor));
  }

  @GetMapping
  public Page<DoctorDetailsListDTO> list(@PageableDefault(size = 10, sort = { "name" }) Pageable pageable) {
    return doctorReposity.findAll(pageable).map(DoctorDetailsListDTO::new);
  }

  @GetMapping("/{id}")
  public ResponseEntity<DoctorDetails> details(@PathVariable Long id) {
    var doctor = doctorReposity.getReferenceById(id);
    return ResponseEntity.ok(new DoctorDetails(doctor));
  }

  @PutMapping
  @Transactional
  public ResponseEntity<DoctorDetails> update(@RequestBody @Valid DoctorUpdateDTO doctor) {
    var targetDoctor = doctorReposity.getReferenceById(doctor.id());
    targetDoctor.updateInfo(doctor);

    return ResponseEntity.ok(new DoctorDetails(targetDoctor));
  }

  @DeleteMapping("/{id}")
  @Transactional
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    doctorReposity.deleteById(id);

    return ResponseEntity.noContent().build();
  }

}
