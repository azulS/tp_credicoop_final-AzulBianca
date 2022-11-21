package ar.edu.utn.link.correlativas.app.repositorios.modelo;

import ar.edu.utn.link.correlativas.model.Publicaciones.Estado;
import ar.edu.utn.link.correlativas.model.Publicaciones.EstadoDeLaPublicacion;
import ar.edu.utn.link.correlativas.model.Publicaciones.Publicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@RepositoryRestController
public class PublicacionControllerComplement {

    @Autowired
    RepoPublicacionJPA repo;
    @Transactional
    public @ResponseBody ResponseEntity<Object> delete (@PathVariable("publicacionId") Long publicacionId) {
        Optional<Publicacion> publicacionOptional = Optional.ofNullable(repo.findById(publicacionId));

        if (publicacionOptional.isPresent()) {
            Publicacion publicacion = publicacionOptional.get();
            publicacionOptional.get().agregarEstadoDePublicacion(Estado.CANCELADO);
            return ResponseEntity.ok("materia borrada ok");
        }
        return ResponseEntity.notFound().build();
    }
}
