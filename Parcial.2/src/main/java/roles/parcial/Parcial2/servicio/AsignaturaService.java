package roles.parcial.Parcial2.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import roles.parcial.Parcial2.entidades.Asignatura;
import roles.parcial.Parcial2.repositorios.AsignaturaRepository;

@Service
public class AsignaturaService {
  
  @Autowired
  private AsignaturaRepository asignaturaRepository;
  
  public List<Asignatura> getAllAsignaturas() {
    return asignaturaRepository.findAll();
  }
  
  public Asignatura getAsignatura(Long id) {
    return asignaturaRepository.findById(id).orElseThrow();
  }
  
  public void createAsignatura(Asignatura asignatura) {
    asignaturaRepository.save(asignatura);
  }
  
  public void updateAsignatura(Asignatura asignatura) {
    asignaturaRepository.save(asignatura);
  }
  
  public void deleteAsignatura(Long id) {
    asignaturaRepository.deleteById(id);
  }
}