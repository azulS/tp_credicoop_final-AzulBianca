package ar.edu.utn.link.correlativas.app.repositorios.modelo;

import ar.edu.utn.link.correlativas.model.dtos.DTOPersonalizacionGestores;
import ar.edu.utn.link.correlativas.model.productos.PersonalizacionGestores;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path = "personalizacionGestores",excerptProjection = DTOPersonalizacionGestores.class)
public interface RepoPersonalizacionGestoresJPA extends JpaRepository<PersonalizacionGestores, Long> {
    Page <PersonalizacionGestores> findById(Long id, Pageable page);

}