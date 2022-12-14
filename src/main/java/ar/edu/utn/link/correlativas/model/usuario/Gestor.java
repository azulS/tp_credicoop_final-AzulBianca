package ar.edu.utn.link.correlativas.model.usuario;

import ar.edu.utn.link.correlativas.app.PersonalizacionGestoresException;
import ar.edu.utn.link.correlativas.app.ProductosCargadosException;
import ar.edu.utn.link.correlativas.model.productos.Producto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@DiscriminatorValue("gestor")
public class Gestor extends Usuario {
    @OneToMany
    private List<Producto> productosCargados;
    public Gestor(){
        this.productosCargados= new ArrayList<>();
    }

    public Gestor(Producto productoNuevo){
        this.productosCargados= new ArrayList<>();
        this.productosCargados.add(productoNuevo);
    }
    public void cargarProducto (Producto productoNuevo) throws ProductosCargadosException {
        if (this.getProductosCargados().contains(productoNuevo)){
            throw new ProductosCargadosException("ya existe este producto", this, productoNuevo);
        }
        this.productosCargados.add(productoNuevo);
    }
    public Collection<Producto> getProductosCargados(){
        return new ArrayList<Producto>(this.productosCargados);
    }

}
