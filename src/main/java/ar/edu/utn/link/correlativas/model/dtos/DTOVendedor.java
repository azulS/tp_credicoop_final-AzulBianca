package ar.edu.utn.link.correlativas.model.dtos;

import ar.edu.utn.link.correlativas.model.usuario.Gestor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="Gestor", types ={Gestor.class})
public interface DTOVendedor{
    @Value("#{target.nombre} #{target.apellido}")
    String getNombreCompleto();
}
