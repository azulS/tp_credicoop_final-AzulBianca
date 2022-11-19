//package ar.edu.utn.link.correlativas.model.correlativas;
//
//import javax.persistence.*;
//import javax.validation.constraints.Min;
//import javax.validation.constraints.NotBlank;
//import java.util.Collection;
//
//@Entity
//@Table(name = "Materia")
//public class Materia {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//
//	@NotBlank
//	private String nombre;
//	@Min(1)
//	private int anio;
//@Transient
//	private Collection<Materia> correlativas;
//
//	public Materia() {}
//
//	public Materia(String nombre, int anio) {
//		super();
//		this.anio = anio;
//		this.nombre = nombre;
//	}
//
//	public Long getId(){
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Integer getAnio() {
//		return anio;
//	}
//
//	public void setAnio(int anio) {
//		this.anio = anio;
//	}
//	public String getNombre() {
//		return nombre;
//	}
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//	public Collection<Materia> getCorrelativas() {
//		return correlativas;
//	}
//	public void setCorrelativas(Collection<Materia> correlativas) {
//		this.correlativas = correlativas;
//	}
//	}
