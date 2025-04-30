package repositories;

import org.springframework.stereotype.Repository;

import model.entities.Administrator;
@Repository
public interface AdministratorRepository extends GeneralRepository<Administrator,Long> {

}
