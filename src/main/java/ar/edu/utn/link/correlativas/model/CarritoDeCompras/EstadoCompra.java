package ar.edu.utn.link.correlativas.model.CarritoDeCompras;

import ar.edu.utn.link.correlativas.model.Persistente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class EstadoCompra extends Persistente {
    @ManyToOne
    @JoinColumn(name = "CarritoDeCompras_id", referencedColumnName= "id")
    private CarritoDeCompras carritoDeCompras;

    @Column
    private LocalDateTime fechaYhora;

    @Enumerated (EnumType.STRING)
    @Column (name = "estadoDelPago")
    private EstadoPagos estado;
    public EstadoCompra(CarritoDeCompras carrito, EstadoPagos estado){
        setEstado(estado);
        setFechaYhora(LocalDateTime.now());
        setCarritoDeCompras(carrito);
    }

}
