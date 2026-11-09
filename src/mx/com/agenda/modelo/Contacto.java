package mx.com.agenda.modelo;

import java.util.Objects;

public class Contacto extends Persona implements Comparable<Contacto> {
    private String telefono;

    public Contacto(String nombre, String apellido, String telefono) {
        super(nombre, apellido);
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Formato que pide la misión: Nombre Apellido - Teléfono
    @Override
    public String mostrarInformacion() {
        return nombre + " " + apellido + " - " + telefono;
    }

    // Dos contactos son iguales si tienen el mismo nombre y apellido (sin importar mayúsculas)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Contacto otro = (Contacto) obj;
        return this.nombre.equalsIgnoreCase(otro.nombre)
                && this.apellido.equalsIgnoreCase(otro.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase(), apellido.toLowerCase());
    }

    // Orden alfabético para Collections.sort(): primero nombre, luego apellido
    @Override
    public int compareTo(Contacto otro) {
        int porNombre = this.nombre.compareToIgnoreCase(otro.nombre);
        if (porNombre != 0) {
            return porNombre;
        }
        return this.apellido.compareToIgnoreCase(otro.apellido);
    }

    @Override
    public String toString() {
        return mostrarInformacion();
    }
}
