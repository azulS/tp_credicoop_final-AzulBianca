package ar.edu.utn.link.correlativas.model.productos;

import ar.edu.utn.link.correlativas.model.Persistente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table
@Entity
@NoArgsConstructor
public class PersonalizacionGestores extends Persistente {
    @ManyToOne
    @JoinColumn(name = "producto_id", referencedColumnName= "id")
    private Producto producto;
    @Column
    private String areasDeImpresion;
    @OneToMany
    private List<TecnicaDeImpresion> tecnicaDeImpresion;

    public PersonalizacionGestores(TecnicaDeImpresion tecnicaNueva, String areasDeImpresion, Producto producto){
        setProducto(producto);
        setAreasDeImpresion(areasDeImpresion);
        this.tecnicaDeImpresion = new ArrayList<>();
        agregarTecnicaDeImpresion(tecnicaNueva);
    }

    public void agregarTecnicaDeImpresion(TecnicaDeImpresion tecnicaNueva){
        this.tecnicaDeImpresion.add(tecnicaNueva);
    }

}