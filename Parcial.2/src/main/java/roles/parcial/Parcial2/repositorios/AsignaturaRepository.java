package roles.parcial.Parcial2.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import roles.parcial.Parcial2.entidades.Asignatura;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {
	  List<Asignatura> findAll();
	}