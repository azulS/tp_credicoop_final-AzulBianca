package ar.edu.utn.link.correlativas.app.repositorios.modelo.sinDTOs;

import ar.edu.utn.link.correlativas.model.CarritoDeCompras.EstadoCompra;
import ar.edu.utn.link.correlativas.model.Publicaciones.PersonalizacionVendedores;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "publicaciones",excerptProjection = PersonalizacionVendedores.class)
public interface RepoPersonalizacionVendedoresJPA extends JpaRepository<PersonalizacionVendedores, Long> {

    Page<EstadoCompra> findById(Long id, Pageable page);
}