package ar.edu.utn.link.correlativas.app.repositorios.modelo;

import ar.edu.utn.link.correlativas.model.Publicaciones.Estado;
import ar.edu.utn.link.correlativas.model.Publicaciones.EstadoDeLaPublicacion;
import ar.edu.utn.link.correlativas.model.Publicaciones.Publicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RepositoryRestController
public class PublicacionControllerComplement {

    @Autowired
    RepoPublicacionJPA repoPublicacion;
    @Transactional
    @DeleteMapping("/publicacion/{productoId}")
    public @ResponseBody ResponseEntity<Object> delete (@PathVariable("publicacionId") Long publicacionId) {
        Optional<Publicacion> publicacionOptional = repoPublicacion.findById(publicacionId);

        if (publicacionOptional.isPresent()) {
            Publicacion publicacion = publicacionOptional.get();
            publicacionOptional.get().agregarEstadoDePublicacion(Estado.CANCELADO);
            return ResponseEntity.ok("Publicacion borrada ok");
        }
        return ResponseEntity.notFound().build();
    }

    @Transactional
    @PostMapping("/publicacionId/{status}")
    public @ResponseBody ResponseEntity<Object> agregarEstado(
            @PathVariable ("publicacionId") Long publicacionId,
            @RequestBody Estado status
    ) throws Exception{
        Optional <Publicacion> publicacionOptional = repoPublicacion.findById(publicacionId);
        EstadoDeLaPublicacion estadoNuevo = new EstadoDeLaPublicacion(publicacionOptional.get(), status);

        return ResponseEntity.ok().build();
    }
}