package ar.edu.utn.link.correlativas.model.Publicaciones;

import ar.edu.utn.link.correlativas.model.Persistente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table
@NoArgsConstructor
public class EstadoDeLaPublicacion extends Persistente {
    @ManyToOne
    @JoinColumn(name = "publicacion_id", referencedColumnName= "id")
    private Publicacion publicacion;
    @Column
    private LocalDate fecha;
    @Enumerated(EnumType.STRING)
    private Estado estado;

    public EstadoDeLaPublicacion(Publicacion publicacion, Estado estado1){
        setPublicacion(publicacion);
        setFecha(LocalDate.from(LocalDateTime.now()));
        setEstado(estado1);
    }
}