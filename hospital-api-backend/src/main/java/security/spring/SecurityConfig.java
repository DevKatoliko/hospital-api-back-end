package security.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import security.firebase.FirebaseAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	private final FirebaseAuthenticationFilter firebaseAuthenticationFilter;
	
	public SecurityConfig(FirebaseAuthenticationFilter firebaseAuthenticationFilter) {
		this.firebaseAuthenticationFilter = firebaseAuthenticationFilter;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception{
		http
		.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(authz -> authz
				.requestMatchers("/public/**").permitAll()
				.anyRequest().authenticated())
		.addFilterBefore(firebaseAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	
}
