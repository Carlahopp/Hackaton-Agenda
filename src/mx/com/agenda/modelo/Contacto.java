package mx.com.agenda.modelo;

public class Contacto implements Comparable<Contacto> {
    private String nombre;
    private String apellido;
    private String telefono;

    public Contacto() {
    }

    public Contacto(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    // Validación lógica de duplicados (contains)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contacto con = (Contacto) obj;
        return this.nombre.equalsIgnoreCase(con.nombre) && this.apellido.equalsIgnoreCase(con.apellido);
    }

    // Regala el criterio de ordenación alfabética por nombre para el Collections.sort()
    @Override
    public int compareTo(Contacto otro) {
        return this.nombre.compareToIgnoreCase(otro.getNombre());
    }
}
