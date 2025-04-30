package exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.google.firebase.auth.FirebaseAuthException;

import exceptions.HospitalNotFoundException;
import exceptions.PersonNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(FirebaseAuthException.class)
	public ResponseEntity<String> handleFirebaseException(FirebaseAuthException ex){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar usuário!" + ex.getMessage());
	}

	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<String> handleUsernameNotFoundException(UsernameNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado! " + ex.getMessage() );
	}
	
	@ExceptionHandler(HospitalNotFoundException.class)
	public ResponseEntity<String> handleHospitalNotFoundException(HospitalNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hospital não encontrado!" + ex.getMessage());
	}
	@ExceptionHandler(PersonNotFoundException.class)
	public ResponseEntity<String> handlePersonNotFoundException(PersonNotFoundException ex){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada!" + ex.getMessage());
	}
}
