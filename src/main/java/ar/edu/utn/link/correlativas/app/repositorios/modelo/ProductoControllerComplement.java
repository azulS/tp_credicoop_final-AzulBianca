package ar.edu.utn.link.correlativas.app.repositorios.modelo;

import ar.edu.utn.link.correlativas.app.repositorios.modelo.RepoPersonalizacionGestoresJPA;
import ar.edu.utn.link.correlativas.model.productos.PersonalizacionGestores;
import ar.edu.utn.link.correlativas.model.productos.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RepositoryRestController
public class ProductoControllerComplement {

    @Autowired
    RepoProductoJPA repoProductoJPA;
    @Autowired
    RepoPersonalizacionGestoresJPA repoPersGest;

    @Transactional
    @DeleteMapping("/producto/{productoId}")
    public @ResponseBody ResponseEntity<Object> delete (@PathVariable("productoId") Long productoId) {
        Optional<Producto> productoOptional = repoProductoJPA.findById(productoId);

        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            productoOptional.get().setActivo(false);

            return ResponseEntity.ok("Producto borrado ok");
        }
        return ResponseEntity.notFound().build();
    }
    @Transactional
    @PostMapping("/producto/{productoId}/personalizacionesGestores")
    public @ResponseBody ResponseEntity<Object> agregarPersonalizacion(
            @PathVariable("productoId") Long productoId,
            @RequestBody Long persGestId
    )throws Exception {
        Optional<Producto> productoOptional = repoProductoJPA.findById(productoId);
        Optional <PersonalizacionGestores> persGestOptional =repoPersGest.findById(persGestId);

      productoOptional.get().getPersonalizacionesGestores().add(persGestOptional.get());

        return ResponseEntity.ok().build();
    }
}

// TODO: 21/11/2022 aca se puede hacer lo de buscar por precio o buscar por medioDePago, me aparece en la lista de search?