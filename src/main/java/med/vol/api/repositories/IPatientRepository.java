package med.vol.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import med.vol.api.entities.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Long> {

}
