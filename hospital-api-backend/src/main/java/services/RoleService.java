package services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

@Service
public class RoleService {

	public void giveRole(String uid, String role) throws FirebaseAuthException{
		Map<String,Object> claim = new HashMap<>();
		claim.put("role", role);
		FirebaseAuth.getInstance().setCustomUserClaims(uid, claim);
	}
	

	
}
