package ar.edu.utn.link.correlativas.model.dtos.correlativas;

import ar.edu.utn.link.correlativas.model.correlativas.Alumno;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="alumno1", types = {Alumno.class})
public interface DTOAlumno {

    @Value("#{target.nombre} #{target.apellido}")
    String getNombreCompleto();

    @Value("#{target.materiasAprobadas.size()}")
    int getCantMateriasAprobadas();
}
