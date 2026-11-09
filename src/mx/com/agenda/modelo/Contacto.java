package mx.com.agenda.modelo;

public class Contacto extends Persona {
    private String telefono;

    public Contacto() {
    }

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }
}
