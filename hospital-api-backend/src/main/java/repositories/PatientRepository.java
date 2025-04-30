package repositories;

import org.springframework.stereotype.Repository;

import model.entities.Patient;
@Repository
public interface PatientRepository extends GeneralRepository<Patient,Long> {
	
}
