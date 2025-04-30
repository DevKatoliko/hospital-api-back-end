package repositories;

import org.springframework.stereotype.Repository;

import model.entities.Doctor;
@Repository
public interface DoctorRepository extends GeneralRepository<Doctor, Long> {

}
