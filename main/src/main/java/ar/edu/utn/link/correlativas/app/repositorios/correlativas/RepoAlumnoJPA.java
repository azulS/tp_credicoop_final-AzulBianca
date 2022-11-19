package ar.edu.utn.link.correlativas.app.repositorios.correlativas;

import ar.edu.utn.link.correlativas.model.dtos.correlativas.DTOAlumno;
import ar.edu.utn.link.correlativas.model.correlativas.Alumno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "alumnos", excerptProjection = DTOAlumno.class)
public interface RepoAlumnoJPA extends JpaRepository<Alumno, Long> {

    Alumno findByNombre(String nombre);
    DTOAlumno findByNombreAndApellido(String nombre, String apellido);
    Page<Alumno> findAlumnoByNombre(String nombre, Pageable page);

}
