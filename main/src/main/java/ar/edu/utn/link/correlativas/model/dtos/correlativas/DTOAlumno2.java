package ar.edu.utn.link.correlativas.model.dtos.correlativas;

import ar.edu.utn.link.correlativas.model.correlativas.Alumno;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="alumno2", types = {Alumno.class})
public interface DTOAlumno2 {

    @Value("#{target.nombre} #{target.apellido}")
    String getNombreCompleto();
}
