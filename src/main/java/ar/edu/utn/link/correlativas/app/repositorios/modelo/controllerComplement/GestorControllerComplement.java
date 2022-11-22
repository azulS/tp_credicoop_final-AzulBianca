package ar.edu.utn.link.correlativas.app.repositorios.modelo.controllerComplement;

import ar.edu.utn.link.correlativas.app.repositorios.modelo.RepoGestorJPA;
import ar.edu.utn.link.correlativas.app.repositorios.modelo.RepoPersonalizacionGestoresJPA;
import ar.edu.utn.link.correlativas.app.repositorios.modelo.RepoProductoJPA;
import ar.edu.utn.link.correlativas.model.productos.PersonalizacionGestores;
import ar.edu.utn.link.correlativas.model.productos.Producto;
import ar.edu.utn.link.correlativas.model.usuario.Gestor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RepositoryRestController
public class GestorControllerComplement {

    @Autowired
    RepoGestorJPA repoGestor;
    @Autowired
    RepoProductoJPA repoProducto;
    @Autowired
    RepoPersonalizacionGestoresJPA repoPersGest;

    @Transactional
    @PostMapping("/gestor/{gestorId}/productosCargados")
    public @ResponseBody ResponseEntity<Object> agregarProducto(
            @PathVariable("gestorId") Long gestorId,
            @RequestBody Long productoId
    )throws Exception {
        Optional<Gestor> gestorOptional = repoGestor.findById(gestorId);
        Optional <Producto> productoOptional =repoProducto.findById(productoId);

        gestorOptional.get().getProductosCargados().add(productoOptional.get());

        return ResponseEntity.ok().build();
    }

    @Transactional
    @PostMapping("/gestor/{gestorId}/producto/{productoId}/personalizacionesGestores")
    public @ResponseBody ResponseEntity<Object> agregarPersonalizacion(
            @PathVariable("productoId") Long productoId,
            @PathVariable("gestorId") Long gestorId,
            @RequestBody Long persGestId
    )throws Exception {
        Optional<Gestor> gestorOptional = repoGestor.findById(gestorId);
        Optional<Producto> productoOptional = repoProducto.findById(productoId);
        Optional <PersonalizacionGestores> persGestOptional =repoPersGest.findById(persGestId);

        productoOptional.get().getPersonalizacionesGestores().add(persGestOptional.get());

        return ResponseEntity.ok().build();
    }

    @Transactional
    @DeleteMapping("/producto/{productoId}")
    public @ResponseBody ResponseEntity<Object> delete (@PathVariable("productoId") Long productoId) {
        Optional<Producto> productoOptional = repoProducto.findById(productoId);

        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();
            productoOptional.get().setActivo(false);

            return ResponseEntity.ok("Producto borrado ok");
        }
        return ResponseEntity.notFound().build();
    }
}
