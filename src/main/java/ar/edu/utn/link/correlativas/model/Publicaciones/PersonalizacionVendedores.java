package ar.edu.utn.link.correlativas.model.Publicaciones;

import ar.edu.utn.link.correlativas.model.Persistente;
import ar.edu.utn.link.correlativas.model.productos.TecnicaDeImpresion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
public class PersonalizacionVendedores extends Persistente {
    @ManyToOne
    @JoinColumn(name = "publicacion_id", referencedColumnName = "id")
    private Publicacion publicacion;
    @Column
    private String archivoImagen;
    @OneToOne
    private TecnicaDeImpresion tecnicaImpresion;
    @Column
    private int precio;

    public PersonalizacionVendedores(Publicacion publicacion, String archivoImagen, int precio){
        this.publicacion = publicacion;
        this.archivoImagen = archivoImagen;
        this.precio = precio;
    }

}