package ar.edu.utn.link.correlativas.model.Publicaciones;

import ar.edu.utn.link.correlativas.model.Persistente;
import ar.edu.utn.link.correlativas.model.productos.Producto;
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
public class ContenidoPublicacion extends Persistente {

    @Column
    private String nombre;
    @ManyToOne
    private Producto producto;
    @OneToMany
    private List<PersonalizacionVendedores> personalizacionesVendedores;

    public ContenidoPublicacion(Publicacion publicacion, Producto producto, String archivoImagen, int precio){
        this.nombre = producto.getNombre();
        this.personalizacionesVendedores =new ArrayList<>();
        PersonalizacionVendedores personalizacionVendedores = new PersonalizacionVendedores(publicacion, archivoImagen, precio);
        this.personalizacionesVendedores.add(personalizacionVendedores);
    }

    public void agregarPersonalizacionVendedor(PersonalizacionVendedores personalizacionNueva){
        this.personalizacionesVendedores.add(personalizacionNueva);
    }
}