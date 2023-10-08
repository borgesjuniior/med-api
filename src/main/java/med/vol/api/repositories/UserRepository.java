package med.vol.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import med.vol.api.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
