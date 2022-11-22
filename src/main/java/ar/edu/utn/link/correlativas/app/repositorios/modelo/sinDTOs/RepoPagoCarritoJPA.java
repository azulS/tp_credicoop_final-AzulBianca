package ar.edu.utn.link.correlativas.app.repositorios.modelo.sinDTOs;

import ar.edu.utn.link.correlativas.model.CarritoDeCompras.PagoCarrito;
import ar.edu.utn.link.correlativas.model.productos.TecnicaDeImpresion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "pagoCarrito",excerptProjection = PagoCarrito.class)
public interface RepoPagoCarritoJPA extends JpaRepository<PagoCarrito, Long> {

    Page<PagoCarrito> findById(Long id, Pageable page);
}