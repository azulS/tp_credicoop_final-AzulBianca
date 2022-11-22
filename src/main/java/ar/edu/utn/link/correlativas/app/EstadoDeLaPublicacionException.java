package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.Publicaciones.Estado;
import ar.edu.utn.link.correlativas.model.Publicaciones.Publicacion;

public class EstadoDeLaPublicacionException extends Exception {
    private Publicacion publicacion;
    private Estado estadoDeLaPublicacion;

    public EstadoDeLaPublicacionException(String message, Publicacion publicacion, Estado estadoDeLaPublicacion){
        super(message);
        this.publicacion = publicacion;
        this.estadoDeLaPublicacion = estadoDeLaPublicacion;

    }
    
}
