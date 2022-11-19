package ar.edu.utn.link.correlativas.app.repositorios.modelo;

import ar.edu.utn.link.correlativas.model.dtos.DTOComprador;
import ar.edu.utn.link.correlativas.model.usuario.Comprador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "comprador",excerptProjection = DTOComprador.class)
public interface RepoCompradorJPA extends JpaRepository<Comprador, Long> {
    @RestResource(exported = false)
    void deleteById(Long id);

    @Override
    @RestResource(exported = false)
    void delete(Comprador id);

    Page<Comprador> findById(Long idComprador, Pageable page);

}
