package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.Publicaciones.Publicacion;
import ar.edu.utn.link.correlativas.model.usuario.Vendedor;

public class PublicacionesException extends Exception {

    private final Publicacion publicacion;
    private final Vendedor vendedor;

    public PublicacionesException(String message, Vendedor vendedor, Publicacion publicacion) {
        super(message);
        this.publicacion = publicacion;
        this.vendedor = vendedor;
    }
}
