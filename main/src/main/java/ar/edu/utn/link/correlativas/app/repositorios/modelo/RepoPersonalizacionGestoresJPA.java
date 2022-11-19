package ar.edu.utn.link.correlativas.app.repositorios.modelo;

import ar.edu.utn.link.correlativas.model.productos.PersonalizacionGestores;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "personalizacionGestores",excerptProjection = PersonalizacionGestores.class)
public interface RepoPersonalizacionGestoresJPA {

    Page<PersonalizacionGestores> findByNombre(String nombre, Pageable page);
    PersonalizacionGestores findById(Long id);

}