package roles.parcial.Parcial2.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import roles.parcial.Parcial2.entidades.Docente;

public interface DocenteRepository extends JpaRepository<Docente, Long> {
	  List<Docente> findAll();
	}