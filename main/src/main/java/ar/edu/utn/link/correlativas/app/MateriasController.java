//package ar.edu.utn.link.correlativas.app;
//
//import ar.edu.utn.link.correlativas.app.repositorios.correlativas.RepoMateriaJPA;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/materias_old")
//public class MateriasController {
//
//    @Autowired
//    RepoMateriaJPA repo;
//
//    /*@GetMapping("/{nombre}")
//    public Materia materia(@PathVariable("nombre") String nombre){
//        return repo.findByNombre(nombre);
//    }*/
//
//    /*@PostMapping("/")
//    public String alta(@RequestBody @Valid Materia materia, BindingResult bindingResult) throws MateriaRepetidaException {
//        if(bindingResult.hasErrors()){
//            return "No está OK";
//        } else {
//            repo.save(materia);
//            return "Materia cargado.";
//        }
//    }*/
//}
