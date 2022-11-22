package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.Publicaciones.Estado;
import ar.edu.utn.link.correlativas.model.Publicaciones.Publicacion;
import ar.edu.utn.link.correlativas.model.productos.Producto;
import ar.edu.utn.link.correlativas.model.usuario.Gestor;

public class ProductosCargadosException extends Exception {
    private Gestor gestor;
    private Producto producto;

    public ProductosCargadosException(String message, Gestor gestor, Producto producto){
        super(message);
        this.producto = producto;
        this.gestor = gestor;

    }

}

