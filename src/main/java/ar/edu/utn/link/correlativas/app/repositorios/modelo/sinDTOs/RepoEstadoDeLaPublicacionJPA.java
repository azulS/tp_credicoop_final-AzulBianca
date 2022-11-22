package ar.edu.utn.link.correlativas.app.repositorios.modelo.sinDTOs;

import ar.edu.utn.link.correlativas.model.Publicaciones.EstadoDeLaPublicacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "estadoPublicacion",excerptProjection = EstadoDeLaPublicacion.class)
public interface RepoEstadoDeLaPublicacionJPA extends JpaRepository<EstadoDeLaPublicacion, Long> {

    Page<EstadoDeLaPublicacion> findById(Long id, Pageable page);
}
