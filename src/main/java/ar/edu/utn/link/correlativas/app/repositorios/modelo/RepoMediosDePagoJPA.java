package ar.edu.utn.link.correlativas.app.repositorios.modelo;

import ar.edu.utn.link.correlativas.model.Publicaciones.MedioDePago;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "factura",excerptProjection = MedioDePago.class)
public interface RepoMediosDePagoJPA extends JpaRepository<MedioDePago, Long> {
    Page<MedioDePago> findById(Long id, Pageable page);

}