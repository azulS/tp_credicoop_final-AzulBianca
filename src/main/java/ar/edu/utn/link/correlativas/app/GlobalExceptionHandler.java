package ar.edu.utn.link.correlativas.app;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MateriaRepetidaException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    String materiaRepetida(MateriaRepetidaException ex){
        return "La materia " + ex.getNombreMateria() + " ya existe.";
    }

    @ExceptionHandler(AlumnoRepetidoException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    String alumnoRepetido(AlumnoRepetidoException ex){
        return "El alumno " + ex.getNombreAlumno() + " ya existe.";
    }

    @ExceptionHandler(PersonalizacionGestoresException.class)
    @ResponseBody //poner el resultado en el body
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String PubliRepetida(PersonalizacionGestoresException ex){
        return ex.getLocalizedMessage();
    }
}