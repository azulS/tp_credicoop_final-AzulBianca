package ar.edu.utn.link.correlativas.model.dtos;


import ar.edu.utn.link.correlativas.model.Publicaciones.ContenidoPublicacion;
import ar.edu.utn.link.correlativas.model.Publicaciones.PersonalizacionVendedores;
import ar.edu.utn.link.correlativas.model.Publicaciones.Publicacion;
import ar.edu.utn.link.correlativas.model.usuario.Vendedor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection( name = "Publicacion", types = {Publicacion.class})
public interface DTOPublicacion {

    @Value("#{target.contenidoPublicacion}")
    ContenidoPublicacion getContenidoPublicacion();

    @Value("#{target.Vendedor")
    Vendedor getUsuario();
}
