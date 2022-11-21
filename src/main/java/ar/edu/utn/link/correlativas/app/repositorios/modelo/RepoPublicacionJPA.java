package ar.edu.utn.link.correlativas.app.repositorios.modelo;

import ar.edu.utn.link.correlativas.model.Publicaciones.Publicacion;
import ar.edu.utn.link.correlativas.model.dtos.DTOPublicacion;
import ar.edu.utn.link.correlativas.model.productos.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "publicacion1",excerptProjection = DTOPublicacion.class)
public interface RepoPublicacionJPA extends JpaRepository<Publicacion, Long> {
    Page<Publicacion> findById(Long id, Pageable page);

}
