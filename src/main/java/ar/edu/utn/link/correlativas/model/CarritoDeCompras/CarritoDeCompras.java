package ar.edu.utn.link.correlativas.model.CarritoDeCompras;

import ar.edu.utn.link.correlativas.model.Persistente;
import ar.edu.utn.link.correlativas.model.Publicaciones.PersonalizacionVendedores;
import ar.edu.utn.link.correlativas.model.usuario.Comprador;
import ar.edu.utn.link.correlativas.model.usuario.Vendedor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CarritoDeCompras")
@Getter
@Setter
@NoArgsConstructor
public class CarritoDeCompras extends Persistente {

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Comprador user;
    @OneToOne
    private Vendedor vendedor;
    @OneToOne
    private PagoCarrito pagoCarrito;
    @OneToMany
    @Column(name = "contenidoCarrito")
    private List<ContenidoCarrito> contenidoCarrito;

    public CarritoDeCompras(PersonalizacionVendedores personalizacionVendedores){
        this.contenidoCarrito = new ArrayList<>();
        ContenidoCarrito contenidoCarrito1= new ContenidoCarrito(personalizacionVendedores);
        this.contenidoCarrito.add(contenidoCarrito1);
        this.pagoCarrito = new PagoCarrito(contenidoCarrito1.getMonto(), this, EstadoPagos.PENDIENTE_PAGO);
    }

    @Override
    public String toString() {
        return "CarritoDeCompras{" +
                "user=" + user +
                ", vendedor=" + vendedor +
                ", pagoCarrito=" + pagoCarrito +
                ", contenidoCarrito=" + contenidoCarrito +
                '}';
    }

    public void agregarContenidoCarrito(ContenidoCarrito contenidoNuevo){
        this.contenidoCarrito.add(contenidoNuevo);
    }
}


//    // TODO: 16/9/2022  hacer una excepcion respecto al servicio externo del que te hace la factura.
//    //  lo mismo una excepcion por si no me aceptan el pago (dos try...catch)
//    //cuando agrego una publicacion al carrito de compras tambien le asigno un producto al Id Carrito de Comprador
//    //cuando agrego una publicaion al carrito de compras le cambio el estado Carrito a comprador
//
//    // TODO: 16/9/2022 hacer excepcion try...catch
//    //  por si el comprador quiere pagar el carrito y alguna de las publicaciones estan canceladas
