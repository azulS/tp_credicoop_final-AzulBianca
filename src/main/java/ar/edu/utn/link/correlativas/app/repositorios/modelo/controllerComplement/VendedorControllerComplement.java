package ar.edu.utn.link.correlativas.app.repositorios.modelo.controllerComplement;

import ar.edu.utn.link.correlativas.app.EstadoDeLaPublicacionException;
import ar.edu.utn.link.correlativas.app.repositorios.modelo.*;
import ar.edu.utn.link.correlativas.model.Publicaciones.Estado;
import ar.edu.utn.link.correlativas.model.Publicaciones.EstadoDeLaPublicacion;
import ar.edu.utn.link.correlativas.model.Publicaciones.MedioDePago;
import ar.edu.utn.link.correlativas.model.Publicaciones.Publicacion;
import ar.edu.utn.link.correlativas.model.usuario.Vendedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RepositoryRestController
public class VendedorControllerComplement {

    @Autowired
    RepoVendedorJPA repoVendedor;
    @Autowired
    RepoPublicacionJPA repoPublicacion;
//    @Autowired
//    RepoFacturaJPA repoFacturas;
    @Autowired
    RepoMediosDePagoJPA repoMediosDePago;
    @Transactional
    @PostMapping("/vendedor/{vendedorId}/publicaciones")
    public @ResponseBody ResponseEntity<Object> agregarPublicacion(
            @PathVariable("vendedorId") Long vendedorId,
            @RequestBody Long publicacionId
    )throws Exception {
        Optional<Vendedor> vendedorOptional = repoVendedor.findById(vendedorId);
        Optional <Publicacion> publicacionOptional = repoPublicacion.findById(publicacionId);

        vendedorOptional.get().getPublicaciones().add(publicacionOptional.get());

        return ResponseEntity.ok().build();
    }

    @Transactional
    @PostMapping("/vendedor/{vendedorId}/mediosDePago")
    public @ResponseBody ResponseEntity<Object> agregarMediosDePago(
            @PathVariable("vendedorId") Long vendedorId,
            @RequestBody Long medioId
    )throws Exception {
        Optional<Vendedor> vendedorOptional = repoVendedor.findById(vendedorId);
        Optional <MedioDePago> medioOptional = repoMediosDePago.findById(medioId);

        vendedorOptional.get().getMediosDePagoAceptados().add(medioOptional.get());

        return ResponseEntity.ok().build();
    }

    @Transactional
    @DeleteMapping("/vendedor/{vendedorId}/publicacion/{productoId}")
    public @ResponseBody ResponseEntity<Object> delete (
            @PathVariable("vendedorId") Long vendedorId,
            @PathVariable("publicacionId") Long publicacionId
    ) throws Exception {
        Optional<Publicacion> publicacionOptional = repoPublicacion.findById(publicacionId);

        if (publicacionOptional.isPresent()) {
            Publicacion publicacion = publicacionOptional.get();
            publicacionOptional.get().agregarEstadoDePublicacion(Estado.CANCELADO);
            return ResponseEntity.ok("Publicacion borrada ok");
        }
        return ResponseEntity.notFound().build();
    }

    @Transactional
    @PostMapping("/vendedor/{vendedorId}/publicacionId/{status}")
    public @ResponseBody ResponseEntity<Object> agregarEstadoDePublicacion(
            @PathVariable("vendedorId") Long vendedorId,
            @PathVariable ("publicacionId") Long publicacionId,
            @RequestBody Estado status
    ) throws Exception{
        Optional <Publicacion> publicacionOptional = repoPublicacion.findById(publicacionId);
        EstadoDeLaPublicacion estadoNuevo = new EstadoDeLaPublicacion(publicacionOptional.get(), status);

        return ResponseEntity.ok().build();

        // TODO: 21/11/2022 conecte con el repositorio de los estados de la publicacion, es cualquiera?

    }

//    @Transactional
//    @PostMapping("/vendedor/{vendedorId}/facturas")
//    public @ResponseBody ResponseEntity<Object> agregarFacturaElectronica(
//            @PathVariable("vendedorId") Long vendedorId,
//            @RequestBody Long facturaId
//    )throws Exception {
//        Optional<Vendedor> vendedorOptional = repoVendedor.findById(vendedorId);
//        Optional <Integer> facturaOptional = repoFacturas.findById(facturaId);
//
//        vendedorOptional.get().getFacturasElectronicas().add(facturaOptional.get());
//
//        return ResponseEntity.ok().build();
//    }

}
