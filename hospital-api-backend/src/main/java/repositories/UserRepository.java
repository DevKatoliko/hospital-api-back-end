package repositories;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import model.entities.User;
@Repository
public interface UserRepository extends GeneralRepository<User, Long>{
	Optional<User> getUserByUid(String uid);
}
