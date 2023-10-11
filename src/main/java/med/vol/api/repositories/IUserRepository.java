package med.vol.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import med.vol.api.entities.User;

public interface IUserRepository extends JpaRepository<User, Long> {

  UserDetails findByLogin(String login);

}
