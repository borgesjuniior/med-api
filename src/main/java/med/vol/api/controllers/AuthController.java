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

@RestController
@RequestMapping("auth")
public class AuthController {

  @Autowired
  private AuthenticationManager manager;

  @PostMapping
  public ResponseEntity<Void> authenticate(@RequestBody LoginDTO data) {
    var token = new UsernamePasswordAuthenticationToken(data.login(), data.password());
    manager.authenticate(token);
    return ResponseEntity.ok().build();
  }

}
