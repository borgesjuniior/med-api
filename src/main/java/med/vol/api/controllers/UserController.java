package med.vol.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import med.vol.api.dtos.LoginDTO;
import med.vol.api.entities.User;
import med.vol.api.repositories.IUserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private IUserRepository userRepository;

  @PostMapping
  public ResponseEntity<LoginDTO> create(@RequestBody User user, UriComponentsBuilder uriBuider) {
    var createdUser = userRepository.save(user);

    var uri = uriBuider.path("/users/{id}").buildAndExpand(createdUser.getId()).toUri();
    return ResponseEntity.created(uri).body(new LoginDTO(createdUser));
  }
}
