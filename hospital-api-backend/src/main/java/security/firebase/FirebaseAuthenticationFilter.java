package security.firebase;

import java.io.IOException;

import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class FirebaseAuthenticationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
			String header = request.getHeader("Authorization");
			
			if(header != null && header.startsWith("Bearer ")) {
				String token = header.substring(7);
				try {
					FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(token);
					
					String uid = decodedToken.getUid();
					String roleFromToken = (String)decodedToken.getClaims().get("role");
					
					if(roleFromToken != null) {
					
						var authorities = List.of(new SimpleGrantedAuthority("ROLE_" + roleFromToken));
						var auth = new UsernamePasswordAuthenticationToken(uid,null, authorities);
						auth.setDetails(Map.of("email",decodedToken.getEmail()));
						if(SecurityContextHolder.getContext().getAuthentication() == null) 
							SecurityContextHolder.getContext().setAuthentication(auth);
					}else {
						response.setStatus(HttpServletResponse.SC_FORBIDDEN);
						return;
					}
				}catch(FirebaseAuthException e){
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					return;}
			}
			filterChain.doFilter(request, response);
	}

}
