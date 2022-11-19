package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.productos.PersonalizacionGestores;
import ar.edu.utn.link.correlativas.model.productos.Producto;

public class PersonalizacionGestoresException extends Exception{

    private final Producto producto;
    private final PersonalizacionGestores personalizacionGestores;

    public PersonalizacionGestoresException(String message, Producto producto, PersonalizacionGestores personalizacionGestores){
        super(message);
        this.producto = producto;
        this.personalizacionGestores = personalizacionGestores;
    }
}