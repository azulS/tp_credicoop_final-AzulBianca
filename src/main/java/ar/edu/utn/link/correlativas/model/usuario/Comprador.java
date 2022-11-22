package ar.edu.utn.link.correlativas.model.usuario;

import ar.edu.utn.link.correlativas.app.CarritosDeComprasException;
import ar.edu.utn.link.correlativas.app.ProductosCargadosException;
import ar.edu.utn.link.correlativas.model.CarritoDeCompras.CarritoDeCompras;
import ar.edu.utn.link.correlativas.model.CarritoDeCompras.EstadoCompra;
import ar.edu.utn.link.correlativas.model.Publicaciones.MedioDePago;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static ar.edu.utn.link.correlativas.model.CarritoDeCompras.EstadoPagos.PENDIENTE_PAGO;

@Entity
@Getter
@Setter
@DiscriminatorValue("comprador")
public class Comprador extends Usuario{
    @OneToMany
    private List<CarritoDeCompras> carritosDeCompras;

    public Comprador() {
        this.carritosDeCompras = new ArrayList<>();
    }

    public void agregarCarrito(CarritoDeCompras carritoDeCompras) throws CarritosDeComprasException {
        if (this.getCarritosDeCompras().contains(carritoDeCompras)){
            throw new CarritosDeComprasException("ya existe este carrito", this, carritoDeCompras);
        }
        this.carritosDeCompras.add(carritoDeCompras);
    }
    public void pagarCarrito(CarritoDeCompras carrito, MedioDePago medioElegido) throws CarritosDeComprasException {
        EstadoCompra esperandoPago= new EstadoCompra(carrito, PENDIENTE_PAGO);
        carrito.getPagoCarrito().agregarEstadoCompra(esperandoPago);
//        carrito.getVendedor().confirmarPago(carrito, medioElegido);
    }
    public Collection<CarritoDeCompras> getCarritosDeCompras(){
        return new ArrayList<CarritoDeCompras>(this.carritosDeCompras);
    }
}