package ar.edu.utn.link.correlativas.app;

public class MateriaRepetidaException extends Throwable {

    private String nombreMateria;

    public MateriaRepetidaException(String message) {
        super();
        this.nombreMateria = message;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

}
