package ar.edu.utn.link.correlativas.app.repositorios.modelo;

import ar.edu.utn.link.correlativas.model.Publicaciones.ContenidoPublicacion;
import ar.edu.utn.link.correlativas.model.dtos.DTOPublicacion;
import ar.edu.utn.link.correlativas.model.usuario.Vendedor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "publicaciones",excerptProjection = DTOPublicacion.class)
public interface RepoContenidoPublicacionJPA extends JpaRepository<ContenidoPublicacion, Long> {
        @Override
        @RestResource(exported = false)
        void deleteById(Long id);

        Page<ContenidoPublicacion> findByNombre(String nombre, Pageable page);
        Page<ContenidoPublicacion> findById(Long id, Pageable page);
        Page<ContenidoPublicacion> findByProducto(Long id, Pageable page);
        Page<ContenidoPublicacion> findByPersonalizacionesVendedores(int precio,Pageable page);

        // TODO: 21/11/2022 quisiera cambiarle el nombre de query a findByPersonalizacionesVendedores
        //  https://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#jpa.query-methods.query-creation
        //  https://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#repository-query-keywords
        // TODO: 21/11/2022 buscar por medio de pago aceptado...rarisimo 
}