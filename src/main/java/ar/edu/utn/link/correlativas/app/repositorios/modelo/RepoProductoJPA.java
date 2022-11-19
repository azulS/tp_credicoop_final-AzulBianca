package ar.edu.utn.link.correlativas.app.repositorios.modelo;

import ar.edu.utn.link.correlativas.model.dtos.DTOProducto;
import ar.edu.utn.link.correlativas.model.productos.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "productos",excerptProjection = DTOProducto.class)
public interface RepoProductoJPA extends JpaRepository<Producto, Long> {

    Page<Producto> findByNombre(String nombre, Pageable page);
    Page<Producto> findById(Long id, Pageable page);
    Page<Producto> findByPrecioBase(int precioBase, Pageable page);
    Page<Producto> findByTiempoDeFabricacion(int tiempoDeFabricacion, Pageable page);
}