package ar.edu.utn.link.correlativas.model.Publicaciones;

import ar.edu.utn.link.correlativas.model.CarritoDeCompras.ContenidoCarrito;
import ar.edu.utn.link.correlativas.model.Persistente;
import ar.edu.utn.link.correlativas.model.productos.Producto;
import ar.edu.utn.link.correlativas.model.usuario.Vendedor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Publicacion")
@Getter
@Setter
@NoArgsConstructor
public class Publicacion extends Persistente {
    @NotBlank
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Vendedor usuario;
    @OneToOne
    private ContenidoPublicacion contenidoPublicacion;
    @OneToMany
    private List<EstadoDeLaPublicacion> estadosDePublicacion;

    public Publicacion(Vendedor vendedor, Producto producto, String archivoImagen, int precio) {
        EstadoDeLaPublicacion estado1= new EstadoDeLaPublicacion(this, Estado.PUBLICADO);
        this.estadosDePublicacion = new ArrayList<>();
        this.estadosDePublicacion.add(estado1);

        ContenidoPublicacion contenidoPublicacion1 = new ContenidoPublicacion(this, producto,archivoImagen,precio);
        this.contenidoPublicacion = contenidoPublicacion1;
    }

    public void agregarEstadoDePublicacion(Estado estado1){
        EstadoDeLaPublicacion estadoNuevo = new EstadoDeLaPublicacion(this, estado1);
        this.estadosDePublicacion.add(estadoNuevo);
    }
}