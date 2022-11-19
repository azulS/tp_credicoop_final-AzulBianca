package ar.edu.utn.link.correlativas.model.Publicaciones;

import ar.edu.utn.link.correlativas.model.Persistente;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Getter
public class MedioDePago extends Persistente {

    @Column
    private String medioDePago;

}

// TODO: 3/11/2022  hace falta este objeto?
