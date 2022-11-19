package ar.edu.utn.link.correlativas.model.CarritoDeCompras;

import ar.edu.utn.link.correlativas.model.Persistente;
import ar.edu.utn.link.correlativas.model.Publicaciones.MedioDePago;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table
@NoArgsConstructor

public class PagoCarrito extends Persistente {
    @OneToOne
    @JoinColumn(name = "carritoDeCompras_id", referencedColumnName = "id")
    private CarritoDeCompras carritoDeCompras;
    @Column
    private int monto;
    @OneToOne
    private MedioDePago medioDePago;
    @OneToMany
    @Column (name = "estadoCarrito")
    private List<EstadoCompra> estadoDeCompra;

    public PagoCarrito (int monto, CarritoDeCompras carrito, EstadoPagos estado){
        this.estadoDeCompra =new ArrayList<>();
        EstadoCompra estadoCompra = new EstadoCompra(carrito, estado);
        this.estadoDeCompra.add(estadoCompra);
    }
    public void confirmar(boolean respuesta){
        this.estadoDeCompra =new ArrayList<>();
        if (respuesta){
            estadoDeCompra.get(getEstadoDeCompra().size()-1).setEstado(EstadoPagos.CONFIRMADO);
        }
        if (!respuesta){
            estadoDeCompra.get(getEstadoDeCompra().size()-1).setEstado(EstadoPagos.RECHAZADO);
        }
        else{
            // TODO: 3/11/2022 try/catch
        }
    }

    public void agregarEstadoCompra(EstadoCompra estadoCompraNuevo){
        this.estadoDeCompra.add(estadoCompraNuevo);
    }

    public void pagar(){
        estadoDeCompra.get(getEstadoDeCompra().size()-1).setEstado(EstadoPagos.PENDIENTE_PAGO);
    }


    // TODO: 3/11/2022 para setear el medioDePago tengo que ver los medios de pago disponibles.
    //  Los medios de pago disponibles:
    //      vendedor.mediosDePagoAceptados().forEach

    // TODO: 3/11/2022 MONTO=
    //      PRECIO GESTOR= carrito.contenidoCarrito.personalizacionVendedores.publicacion.contenidoPublicacion.producto.precioBase
    //      PRECIO VENDEDOR= carrito.contenidoCarrito.personalizacionVendedores.precio

}