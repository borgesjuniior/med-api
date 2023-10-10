package med.vol.api.configs;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import med.vol.api.repositories.UserRepository;
import med.vol.api.services.TokenService;

@Component // generic component from Spring
public class SecurityFilter extends OncePerRequestFilter {

  @Autowired
  private TokenService tokenService;

  @Autowired
  private UserRepository userRepository;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    var token = getToken(request);

    if (token != null) {
      var subject = tokenService.getSubject(token);
      var user = userRepository.findByLogin(subject);

      var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
      SecurityContextHolder.getContext().setAuthentication(authentication); // Authenticate user
    }

    filterChain.doFilter(request, response);
  }

  private String getToken(HttpServletRequest request) {
    var authorizationHeader = request.getHeader("Authorization");

    if (authorizationHeader != null) {
      return authorizationHeader.replace("Bearer ", "");
    }

    return null;
  }

}
