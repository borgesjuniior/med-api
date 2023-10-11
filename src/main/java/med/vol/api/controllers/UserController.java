package med.vol.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.vol.api.dtos.LoginDTO;
import med.vol.api.entities.User;
import med.vol.api.repositories.IUserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private IUserRepository userRepository;

  @PostMapping
  public ResponseEntity<LoginDTO> create(@RequestBody User user) {
    var createdUser = userRepository.save(user);
    return ResponseEntity.created(null).body(new LoginDTO(createdUser));
  }
}
