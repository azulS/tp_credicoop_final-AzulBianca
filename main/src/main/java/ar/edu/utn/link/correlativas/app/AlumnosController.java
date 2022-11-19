//package ar.edu.utn.link.correlativas.app;
//
//import ar.edu.utn.link.correlativas.app.repositorios.correlativas.RepoMateriaJPA;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/alumnos_old")
//public class AlumnosController {
//
//    @Autowired
//    RepoMateriaJPA repo;
///*
//    @GetMapping(path={"","/"})
//    public Page<Alumno> alumnos(Pageable page){
//        return repo.page(page);
//    }
//
//    @GetMapping("/{nombre}")
//    public Alumno alumno(@PathVariable("nombre") String nombre){
//        return repo.porNombre(nombre);
//    }
//
//    @PostMapping("/")
//    public String alta(@RequestBody @Valid Alumno alumno, BindingResult bindingResult) throws AlumnoRepetidoException {
//        if(bindingResult.hasErrors()){
//            return "No está OK";
//        } else {
//            repo.save(alumno);
//            return "Alumno cargado.";
//        }
//    }*/
//
//
//}
