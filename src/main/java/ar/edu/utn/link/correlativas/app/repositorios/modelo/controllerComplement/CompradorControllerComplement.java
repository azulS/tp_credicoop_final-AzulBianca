package ar.edu.utn.link.correlativas.app.repositorios.modelo.controllerComplement;


import ar.edu.utn.link.correlativas.app.CarritosDeComprasException;
import ar.edu.utn.link.correlativas.app.repositorios.modelo.RepoCompradorJPA;
import ar.edu.utn.link.correlativas.app.repositorios.modelo.RepoMediosDePagoJPA;
import ar.edu.utn.link.correlativas.app.repositorios.modelo.sinDTOs.RepoCarritoJPA;
import ar.edu.utn.link.correlativas.app.repositorios.modelo.sinDTOs.RepoContenidoCarritoJPA;
import ar.edu.utn.link.correlativas.app.repositorios.modelo.sinDTOs.RepoEstadoCompraJPA;
import ar.edu.utn.link.correlativas.app.repositorios.modelo.sinDTOs.RepoPersonalizacionVendedoresJPA;
import ar.edu.utn.link.correlativas.model.CarritoDeCompras.CarritoDeCompras;
import ar.edu.utn.link.correlativas.model.Publicaciones.MedioDePago;
import ar.edu.utn.link.correlativas.model.Publicaciones.PersonalizacionVendedores;
import ar.edu.utn.link.correlativas.model.usuario.Comprador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@RepositoryRestController
public class CompradorControllerComplement {

    @Autowired
    RepoCompradorJPA repoComprador;
    @Autowired
    RepoCarritoJPA repoCarrito;
    @Autowired
    RepoContenidoCarritoJPA repoContenido;
    @Autowired
    RepoEstadoCompraJPA repoEstado;
    @Autowired
    RepoPersonalizacionVendedoresJPA repoPersVend;

    @Transactional
    @PostMapping("/comprador/{compradorId}/carritoDeCompras")
    public @ResponseBody ResponseEntity<Object> agregarCarrito(
            @PathVariable("compradorId") Long compradorId,
            @RequestBody Long carritoId
    )throws Exception {
        Optional<Comprador> compradorOptional = repoComprador.findById(compradorId);
        Optional <CarritoDeCompras> carritoOptional =repoCarrito.findById(carritoId);

        compradorOptional.get().getCarritosDeCompras().add(carritoOptional.get());

        return ResponseEntity.ok().build();
    }

    @Transactional
    @PostMapping("/comprador/{compradorId}/carrito/{carritoId}/personalizacionId")
    public @ResponseBody ResponseEntity<Object> agregarContenidoCarrito(
            @PathVariable("compradorId") Long compradorId,
            @PathVariable("carritoId") Long carritoId,
            @RequestBody Long personalizacionId
    ) {
        Optional<CarritoDeCompras> carritoOptional = repoCarrito.findById(carritoId);
        Optional <PersonalizacionVendedores> persVendOptional =repoPersVend.findById(personalizacionId);

        carritoOptional.get().agregarContenidoCarrito(persVendOptional.get());

        // TODO: 21/11/2022 tendria que agregar al repoContenido el contenidoCarrito que se creo en esta jugada?
        //todo: si excepcion por si no existe el contenido que se quiere agregar

        return ResponseEntity.ok().build();
    }
    @Autowired
    RepoMediosDePagoJPA repoMedio;

    @Transactional
    @PostMapping("/comprador/{compradorId}/carrito/{carritoId}/pagar")
    public @ResponseBody ResponseEntity<Object> pagarCarrito(
            @PathVariable("compradorId") Long compradorId,
            @PathVariable("carritoId") Long carritoId,
            @RequestBody Long medioDePagoId
    ) throws CarritosDeComprasException {
        Optional<CarritoDeCompras> carritoOptional = repoCarrito.findById(carritoId);
        Optional<Comprador> compradorOptional = repoComprador.findById(compradorId);
        Optional <MedioDePago> medioOptional =repoMedio.findById(medioDePagoId);

        compradorOptional.get().pagarCarrito(carritoOptional.get(), medioOptional.get());

        return ResponseEntity.ok().build();
    }

}
