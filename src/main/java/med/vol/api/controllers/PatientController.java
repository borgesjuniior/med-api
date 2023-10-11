package med.vol.api.controllers;

import jakarta.validation.Valid;
import med.vol.api.dtos.DetailsPatient;
import med.vol.api.dtos.PatientRegisterData;
import med.vol.api.entities.Patient;
import med.vol.api.repositories.IPatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("patients")
public class PatientController {

    @Autowired
    private IPatientRepository patientRepository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid PatientRegisterData data, UriComponentsBuilder uriBuilder) {
        var paciente = new Patient(data);
        patientRepository.save(paciente);

        var uri = uriBuilder.path("/patients/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetailsPatient(paciente));
    }

}
