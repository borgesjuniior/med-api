package med.vol.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.vol.api.dtos.LoginDTO;
import med.vol.api.dtos.TokenDTO;
import med.vol.api.entities.User;
import med.vol.api.services.TokenService;

@RestController
@RequestMapping("auth")
public class AuthController {

  @Autowired
  private AuthenticationManager manager;

  @Autowired
  private TokenService tokenService;

  @PostMapping
  public ResponseEntity<TokenDTO> authenticate(@RequestBody LoginDTO data) {
    var token = new UsernamePasswordAuthenticationToken(data.login(), data.password());
    var authentication = manager.authenticate(token);
    var generatedToken = tokenService.generateToken((User) authentication.getPrincipal());
    return ResponseEntity.ok(new TokenDTO(generatedToken));
  }

}
