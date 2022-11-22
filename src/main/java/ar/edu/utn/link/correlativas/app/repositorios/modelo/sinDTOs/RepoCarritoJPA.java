package ar.edu.utn.link.correlativas.app.repositorios.modelo.sinDTOs;

import ar.edu.utn.link.correlativas.model.CarritoDeCompras.CarritoDeCompras;
import ar.edu.utn.link.correlativas.model.dtos.DTOProducto;
import ar.edu.utn.link.correlativas.model.productos.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "carrito",excerptProjection = CarritoDeCompras.class)
public interface RepoCarritoJPA extends JpaRepository<CarritoDeCompras, Long> {

    Page<CarritoDeCompras> findById(Long id, Pageable page);
}