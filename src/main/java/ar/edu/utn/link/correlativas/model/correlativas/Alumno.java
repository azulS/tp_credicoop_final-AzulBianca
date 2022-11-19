package ar.edu.utn.link.correlativas.model.correlativas;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Alumno")
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String nombre;

	@NotBlank
	private String apellido;
//	@Transient
//	@JsonIgnore
//	private List<Curso> cursos;
//	@Transient
//	@ManyToMany
//	private Collection<Materia>  materiasAprobadas;

	public Alumno() {}

	public Alumno(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
//		this.materiasAprobadas = new ArrayList<>();
	}

	public Long getId(){
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
//	public List<Curso> getCursos() {
//		return cursos;
//	}
//	public void setCursos(List<Curso> cursos) {
//		this.cursos = cursos;
//	}
////	public Collection<Materia> getMateriasAprobadas() {
//		return  materiasAprobadas;
//	}
//	public void setMateriasAprobadas(Collection<Materia> materiasAprobadas) {
//		this.materiasAprobadas = materiasAprobadas;
//	}
//
//	public void inscribir(Curso curso) {
//		// TODO Auto-generated method stub
//
//	}
//
	
	

}
