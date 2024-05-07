package roles.parcial.Parcial2.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import roles.parcial.Parcial2.entidades.User;

public interface UserRepository extends JpaRepository<User, Long> {
	  User findByUsernameAndPassword(String username, String password);
	}