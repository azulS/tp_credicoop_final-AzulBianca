package ar.edu.utn.link.correlativas.app.repositorios.modelo.sinDTOs;

import ar.edu.utn.link.correlativas.model.productos.TecnicaDeImpresion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "carrito",excerptProjection = TecnicaDeImpresion.class)
public interface RepoTecnicaDeImpresionJPA extends JpaRepository<TecnicaDeImpresion, Long> {

    Page<TecnicaDeImpresion> findById(Long id, Pageable page);
}