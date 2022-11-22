package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.Publicaciones.MedioDePago;
import ar.edu.utn.link.correlativas.model.usuario.Vendedor;

public class MediosDePagoAceptadosException extends Exception {

    private final MedioDePago medioDePago;
    private final Vendedor vendedor;

    public MediosDePagoAceptadosException(String message, Vendedor vendedor, MedioDePago medioDePago) {
        super(message);
        this.medioDePago = medioDePago;
        this.vendedor = vendedor;
    }
}