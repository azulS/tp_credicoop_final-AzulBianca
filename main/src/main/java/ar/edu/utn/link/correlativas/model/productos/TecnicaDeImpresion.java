package ar.edu.utn.link.correlativas.model.productos;

import ar.edu.utn.link.correlativas.model.Persistente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="TecnicaDeImpresion")
@Getter
@Setter
@NoArgsConstructor
public class TecnicaDeImpresion extends Persistente {
    @Column
    public String nombre;
    @Column
    public String descripcion;

    public TecnicaDeImpresion(String nombre, String descripcion){
        setDescripcion(descripcion);
        setNombre(nombre);
    }

}
