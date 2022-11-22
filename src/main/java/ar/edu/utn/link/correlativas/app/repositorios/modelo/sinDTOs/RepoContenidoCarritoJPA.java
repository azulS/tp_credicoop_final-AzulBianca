package ar.edu.utn.link.correlativas.app.repositorios.modelo.sinDTOs;

import ar.edu.utn.link.correlativas.model.CarritoDeCompras.CarritoDeCompras;
import ar.edu.utn.link.correlativas.model.CarritoDeCompras.ContenidoCarrito;
import ar.edu.utn.link.correlativas.model.dtos.DTOProducto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "contenidoCarrito",excerptProjection = ContenidoCarrito.class)
public interface RepoContenidoCarritoJPA extends JpaRepository<ContenidoCarrito, Long> {

    Page<ContenidoCarrito> findById(Long id, Pageable page);
}