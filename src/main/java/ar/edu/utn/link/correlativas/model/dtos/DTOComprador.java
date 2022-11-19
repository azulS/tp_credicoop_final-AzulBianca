package ar.edu.utn.link.correlativas.model.dtos;

import ar.edu.utn.link.correlativas.model.usuario.Comprador;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection( name = "comprador", types = {Comprador.class})
public interface DTOComprador {
    @Value("#{target.id}")
    Long getIdComprador();
    @Value("#{target.carritosDeCompras.size()}")
    int getCarritosDeCompras();
}
