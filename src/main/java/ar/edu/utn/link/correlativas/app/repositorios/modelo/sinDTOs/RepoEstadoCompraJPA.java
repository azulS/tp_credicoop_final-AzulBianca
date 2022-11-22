package ar.edu.utn.link.correlativas.app.repositorios.modelo.sinDTOs;

import ar.edu.utn.link.correlativas.model.CarritoDeCompras.EstadoCompra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "estadoCarrito",excerptProjection = EstadoCompra.class)
public interface RepoEstadoCompraJPA extends JpaRepository<EstadoCompra, Long> {

    Page<EstadoCompra> findById(Long id, Pageable page);
}