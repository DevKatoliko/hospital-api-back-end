package security.firebase;

import java.io.FileInputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class FirebaseConfig {
	private final String firebaseKeyPath = "/home/rubens/eclipse-workspace/hospital-api-backend/hospital-backend-api-firebase-adminsdk-fbsvc-494f7c3663.json"; 
	
	@Bean
	public void init() {
		try {
			FileInputStream serviceAccount = new FileInputStream(firebaseKeyPath);
			
			FirebaseOptions options = FirebaseOptions.builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
					.build();
			
			if (FirebaseApp.getApps().isEmpty()) {
				FirebaseApp.initializeApp(options);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
