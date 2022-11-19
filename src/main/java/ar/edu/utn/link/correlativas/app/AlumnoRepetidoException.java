package ar.edu.utn.link.correlativas.app;

public class AlumnoRepetidoException extends Exception {
    private String nombreAlumno;

    public AlumnoRepetidoException(String message) {
        super();
        this.nombreAlumno = message;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

}
