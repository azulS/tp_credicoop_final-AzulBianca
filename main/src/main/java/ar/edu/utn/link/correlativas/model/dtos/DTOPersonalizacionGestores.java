package ar.edu.utn.link.correlativas.model.dtos;

import ar.edu.utn.link.correlativas.model.productos.PersonalizacionGestores;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection( name = "personalizacionGestor1", types = {PersonalizacionGestores.class})
public interface DTOPersonalizacionGestores {
    @Value("#{target.id}")
    Long getIdPersonalizacionGestor();
}
