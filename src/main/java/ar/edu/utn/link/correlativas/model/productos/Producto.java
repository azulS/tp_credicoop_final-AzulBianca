package ar.edu.utn.link.correlativas.model.productos;

import ar.edu.utn.link.correlativas.app.PersonalizacionGestoresException;
import ar.edu.utn.link.correlativas.model.usuario.Gestor;
import ar.edu.utn.link.correlativas.model.Persistente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Producto extends Persistente {

    @Column
    private String nombre;
    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Gestor usuario;
    @Column
    private String descripcion;
    @Column
    private int precioBase;
    @Column
    private int tiempoDeFabricacion;
    @Column
    private boolean activo;
    @OneToMany
    private List<PersonalizacionGestores> personalizacionesGestores;

    public Producto(String nombre, Gestor usuario, int precioBase) {
        setNombre(nombre);
        setUsuario(usuario);
        setPrecioBase(precioBase);
        this.personalizacionesGestores = new ArrayList<>();
        this.activo=true;
    }
    public void agregarPersonalizacionGestores(PersonalizacionGestores personalizacionNueva)
            throws PersonalizacionGestoresException {
        if(this.getPersonalizacionesGestores().contains(personalizacionNueva)){
            throw  new PersonalizacionGestoresException ("ya tiene esta perosnalizacion", this,personalizacionNueva);
        }
        this.personalizacionesGestores.add(personalizacionNueva);
    }
    public Collection<PersonalizacionGestores> getPersonalizacionesGestores(){
        return new ArrayList<PersonalizacionGestores>(this.personalizacionesGestores);
    }

}
