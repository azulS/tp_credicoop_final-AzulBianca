//package ar.edu.utn.link.correlativas.app.repositorios.correlativas;
//
//import ar.edu.utn.link.correlativas.app.MateriaRepetidaException;
//import ar.edu.utn.link.correlativas.model.correlativas.Materia;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//
//import java.util.List;
//
//public interface RepoMateria {
//    public void save(Materia m) throws MateriaRepetidaException;
//
//    public List<Materia> all();
//
//    public boolean existeMateriaDeNombre(String nombre);
//
//    public Page<Materia> page(Pageable page);
//
//    public Materia porNombre(String nombre);
//
//    public List<Materia> porAnio(int anio);
//
//}
