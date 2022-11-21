package ar.edu.utn.link.correlativas.app.repositorios.modelo;

import ar.edu.utn.link.correlativas.model.Publicaciones.Publicacion;
import ar.edu.utn.link.correlativas.model.dtos.DTOPublicacion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "publicacion1",excerptProjection = DTOPublicacion.class)
public interface RepoPublicacionJPA {
    Publicacion findById(Long id);

}
