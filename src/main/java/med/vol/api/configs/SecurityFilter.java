package med.vol.api.configs;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import med.vol.api.services.TokenService;

@Component // generic component from Spring
public class SecurityFilter extends OncePerRequestFilter {

  @Autowired
  private TokenService tokenService;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    var token = getToken(request);
    tokenService.getSubject(token);
    filterChain.doFilter(request, response);
  }

  private String getToken(HttpServletRequest request) {
    var authorizationHeader = request.getHeader("Authorization");

    if (authorizationHeader == null) {
      throw new RuntimeException("JWT Token not found");
    }

    return authorizationHeader.replace("Bearer ", "");
  }

}
