package roles.parcial.Parcial2.entidades;

import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Asignatura {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nombreAsignatura;
  private String descripcion;
  private Integer salon;
  private Time horarioInicio;
  private Time horarioFin;
  @ManyToOne
  @JoinColumn(name = "docente_encargado_id")
  private Docente docenteEncargado;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getNombreAsignatura() {
	return nombreAsignatura;
}
public void setNombreAsignatura(String nombreAsignatura) {
	this.nombreAsignatura = nombreAsignatura;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}
public Integer getSalon() {
	return salon;
}
public void setSalon(Integer salon) {
	this.salon = salon;
}
public Time getHorarioInicio() {
	return horarioInicio;
}
public void setHorarioInicio(Time horarioInicio) {
	this.horarioInicio = horarioInicio;
}
public Time getHorarioFin() {
	return horarioFin;
}
public void setHorarioFin(Time horarioFin) {
	this.horarioFin = horarioFin;
}
public Docente getDocenteEncargado() {
	return docenteEncargado;
}
public void setDocenteEncargado(Docente docenteEncargado) {
	this.docenteEncargado = docenteEncargado;
}
public Asignatura(Long id, String nombreAsignatura, String descripcion, Integer salon, Time horarioInicio,
		Time horarioFin, Docente docenteEncargado) {
	super();
	this.id = id;
	this.nombreAsignatura = nombreAsignatura;
	this.descripcion = descripcion;
	this.salon = salon;
	this.horarioInicio = horarioInicio;
	this.horarioFin = horarioFin;
	this.docenteEncargado = docenteEncargado;
}
public Asignatura() {
	super();
}
  
  
  
  
}