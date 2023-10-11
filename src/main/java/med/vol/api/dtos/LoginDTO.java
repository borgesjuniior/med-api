package med.vol.api.dtos;

import med.vol.api.entities.User;

public record LoginDTO(String login, String password) {
  public LoginDTO(User user) {
    this(user.getLogin(), user.getPassword());
  }
}
