package mx.com.agenda.modelo;

public abstract class Persona {
  protected string  nombre;
  protected string apellido;
}
public Persona(String nombre, String apellido) {
    this.nombre = nombre;
    this.apellido = apellido;
}

public String getNombre() {
    return nombre;
}

public String getApellido() {
    return apellido;

}


