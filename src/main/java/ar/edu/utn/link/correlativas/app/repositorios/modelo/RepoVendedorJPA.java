package ar.edu.utn.link.correlativas.app.repositorios.modelo;

import ar.edu.utn.link.correlativas.model.dtos.DTOVendedor;
import ar.edu.utn.link.correlativas.model.usuario.Vendedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "vendedor",excerptProjection = DTOVendedor.class)
public interface RepoVendedorJPA extends JpaRepository<Vendedor, Long> {
    @Override
    @RestResource(exported = false)
    void deleteById(Long id);

    @Override
    @RestResource(exported = false)
    void delete(Vendedor id);

    Page<Vendedor> findById(Long idVendedor, Pageable page);

}
