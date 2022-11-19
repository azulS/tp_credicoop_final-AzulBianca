package ar.edu.utn.link.correlativas.model.usuario;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Usuario")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING,
        name="tipoDeUsuario")
@Setter
@Getter
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id" , nullable = false)
    private Long id;
    @Column
    private String password;
    public Usuario() {
    }


    // TODO: 16/9/2022 hacer excepciones try...catch por si se confundio la contrasenia al entrar

}
