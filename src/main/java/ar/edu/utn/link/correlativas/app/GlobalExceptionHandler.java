package ar.edu.utn.link.correlativas.app;

import ar.edu.utn.link.correlativas.model.productos.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EstadoDeLaPublicacionException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String estadoRepetido(EstadoDeLaPublicacionException ex){
        return ex.getLocalizedMessage();
    }

    @ExceptionHandler(ProductosCargadosException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String productoRepetido(ProductosCargadosException ex){
        return ex.getLocalizedMessage();
    }
    @ExceptionHandler(PersonalizacionGestoresException.class)
    @ResponseBody //poner el resultado en el body
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String PubliRepetida(PersonalizacionGestoresException ex){
        return ex.getLocalizedMessage();
    }

    @ExceptionHandler(PublicacionesException.class)
    @ResponseBody //poner el resultado en el body
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String PubliRepetida(PublicacionesException ex){
        return ex.getLocalizedMessage();
    }

//    @ExceptionHandler(FacturasElectronicasException.class)
//    @ResponseBody //poner el resultado en el body
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    String FacturaRepetida(FacturasElectronicasException ex){
//        return ex.getLocalizedMessage();
//    }

    @ExceptionHandler(MediosDePagoAceptadosException.class)
    @ResponseBody //poner el resultado en el body
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String MedioRepetido(MediosDePagoAceptadosException ex){ return ex.getLocalizedMessage();
    }

    @ExceptionHandler(CarritosDeComprasException.class)
    @ResponseBody //poner el resultado en el body
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String CarritoRepetido(CarritosDeComprasException ex){ return ex.getLocalizedMessage();
    }


}