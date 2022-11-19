package ar.edu.utn.link.correlativas;

import ar.edu.utn.link.correlativas.app.repositorios.correlativas.RepoAlumnoJPA;
import ar.edu.utn.link.correlativas.app.repositorios.modelo.RepoCompradorJPA;
import ar.edu.utn.link.correlativas.app.repositorios.modelo.RepoGestorJPA;
import ar.edu.utn.link.correlativas.app.repositorios.modelo.RepoProductoJPA;
import ar.edu.utn.link.correlativas.model.correlativas.Alumno;
import ar.edu.utn.link.correlativas.model.productos.Producto;
import ar.edu.utn.link.correlativas.model.usuario.Comprador;
import ar.edu.utn.link.correlativas.model.usuario.Gestor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class AppCorrelativas {

    @Autowired
    RepositoryRestConfiguration config;


    public static void main(String[] args) {
        SpringApplication.run(AppCorrelativas.class, args);
    }

    @Bean
    public CommandLineRunner comprador(RepoGestorJPA repo) {
        config.exposeIdsFor(Comprador.class);

        return (args) -> {
            repo.save(new Gestor());
            repo.save(new Gestor());
            repo.save(new Gestor());
        };
    }

    @Bean
    public CommandLineRunner alumno(RepoAlumnoJPA repo){
        config.exposeIdsFor(Alumno.class);

        return (args) -> {
            repo.save(new Alumno("Juan", "Gomez"));
            repo.save(new Alumno("Luis", "Lopez"));
            repo.save(new Alumno("Carlos", "Gardel"));
            repo.save(new Alumno("Laura", "Pereyra"));
        };
    }
}
