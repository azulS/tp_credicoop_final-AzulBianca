package ar.edu.utn.link.correlativas.app.repositorios.modelo;

import ar.edu.utn.link.correlativas.model.dtos.DTOGestor;
import ar.edu.utn.link.correlativas.model.usuario.Gestor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "gestor",excerptProjection = DTOGestor.class)
public interface RepoGestorJPA extends JpaRepository<Gestor, Long> {
    @Override
    @RestResource(exported = false)
    void deleteById(Long id);

    @Override
    @RestResource(exported = false)
    void delete(Gestor id);

    Page<Gestor> findById(Long idGestor, Pageable page);
}
