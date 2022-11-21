package ar.edu.utn.link.correlativas.model.dtos;

import ar.edu.utn.link.correlativas.model.Publicaciones.ContenidoPublicacion;
import ar.edu.utn.link.correlativas.model.Publicaciones.MedioDePago;
import ar.edu.utn.link.correlativas.model.usuario.Gestor;
import ar.edu.utn.link.correlativas.model.usuario.Vendedor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name="vendedor", types ={Vendedor.class})
public interface DTOVendedor{
    @Value("#{target.nombre} #{target.apellido}")
    String getNombreCompleto();
    @Value("#{target.contenidoPublicacion}")
    ContenidoPublicacion getContenidoPublicacion();
    @Value("#{target.mediosDePago")
    MedioDePago getMediosDePagoAceptados();

    @Value("#{target.facturasElectronicas}")
    Integer getFacturasElectronicas();


}
