package ar.edu.utn.link.correlativas.model;

import ar.edu.utn.link.correlativas.model.CarritoDeCompras.CarritoDeCompras;

public interface ServicioExterno {
    Integer id= Integer.valueOf("123546");
    public static String generarFacturaElectronica(CarritoDeCompras carrito){
        return "Factura numero="+ id;
    }
}

// TODO: 4/11/2022 habria que hacer que las id sean numeros random o ver que es una factura asi es mas cheto
// TODO: 4/11/2022 se supone que tendria que ser una interfaz
