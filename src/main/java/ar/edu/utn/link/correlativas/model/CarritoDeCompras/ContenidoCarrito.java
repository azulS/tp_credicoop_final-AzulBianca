package ar.edu.utn.link.correlativas.model.CarritoDeCompras;

import ar.edu.utn.link.correlativas.model.Persistente;
import ar.edu.utn.link.correlativas.model.Publicaciones.PersonalizacionVendedores;
import ar.edu.utn.link.correlativas.model.productos.Producto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="ContenidoCarrito")
@Getter
@Setter
@NoArgsConstructor
public class ContenidoCarrito extends Persistente {

    @ManyToOne
    @JoinColumn(name="carrito_id", referencedColumnName = "id")
    private CarritoDeCompras carrito;

    @OneToOne
    private PersonalizacionVendedores personalizacionVendedores;

    @Column
    private int cantidad;

    public ContenidoCarrito(PersonalizacionVendedores personalizacionVendedores){
        this.personalizacionVendedores = personalizacionVendedores;
        this.cantidad = 1;
    }
    public void sumarCantidad(int numero){
        this.cantidad = cantidad +numero;
    }
    public int getMonto(){
        int precioPersonalizacion=
                this.personalizacionVendedores.getPrecio()
                +this.personalizacionVendedores.getPublicacion().getContenidoPublicacion().getProducto().getPrecioBase();
        int precioTotal = precioPersonalizacion
                *this.cantidad;
        return precioTotal;
    }
}
//TODO si la cantidad es igual a cero lo saca del carrito, la cantidad no puede ser menor a cero