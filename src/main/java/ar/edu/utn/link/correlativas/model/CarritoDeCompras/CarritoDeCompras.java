package ar.edu.utn.link.correlativas.model.CarritoDeCompras;

import ar.edu.utn.link.correlativas.app.EstadoDeLaPublicacionException;
import ar.edu.utn.link.correlativas.model.Persistente;
import ar.edu.utn.link.correlativas.model.Publicaciones.Estado;
import ar.edu.utn.link.correlativas.model.Publicaciones.PersonalizacionVendedores;
import ar.edu.utn.link.correlativas.model.productos.Producto;
import ar.edu.utn.link.correlativas.model.usuario.Comprador;
import ar.edu.utn.link.correlativas.model.usuario.Vendedor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
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

    public void agregarContenidoCarrito(PersonalizacionVendedores personalizacion){

//        if (this.contenidoCarrito.contains(personalizacion))
//        {
//            this.contenidoCarrito.equals(personalizacion).getId();
//            sumarCantidad(1);
//        }  todo si ya tiene ese elemento en el carrito solo sumarle 1 a la cantidad
        ContenidoCarrito contenidoNuevo = new ContenidoCarrito(personalizacion);
        this.contenidoCarrito.add(contenidoNuevo);
    }
    public Collection<ContenidoCarrito> getContenidoCarrito(){
        return new ArrayList<ContenidoCarrito>(this.contenidoCarrito);
    }
}


//    // TODO: 16/9/2022  hacer una excepcion respecto al servicio externo del que te hace la factura.
//    //  lo mismo una excepcion por si no me aceptan el pago (dos try...catch)
//    //cuando agrego una publicacion al carrito de compras tambien le asigno un producto al Id Carrito de Comprador
//    //cuando agrego una publicaion al carrito de compras le cambio el estado Carrito a comprador
//
//    // TODO: 16/9/2022 hacer excepcion try...catch
//    //  por si el comprador quiere pagar el carrito y alguna de las publicaciones estan canceladas
