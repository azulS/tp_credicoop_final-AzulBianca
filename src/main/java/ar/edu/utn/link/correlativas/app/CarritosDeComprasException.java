package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.CarritoDeCompras.CarritoDeCompras;
import ar.edu.utn.link.correlativas.model.usuario.Comprador;

public class CarritosDeComprasException extends Exception{

    private final CarritoDeCompras carritoDeCompras;
    private final Comprador comprador;

    public CarritosDeComprasException(String message, Comprador comprador, CarritoDeCompras carritoDeCompras){
        super(message);
        this.carritoDeCompras = carritoDeCompras;
        this.comprador = comprador;
    }
}
