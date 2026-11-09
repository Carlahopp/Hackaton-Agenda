package mx.com.agenda.servicio;

import mx.com.agenda.modelo.Contacto;

public class Agenda implements OperacionesAgenda {

    @Override
    public Contacto buscaContacto(String nombre, String apellido) {
        int posicion = contactos.indexOf(new Contacto(nombre, apellido, ""));
        return (posicion >= 0) ? contactos.get(posicion) : null;
    }

    @Override
    public boolean eliminarContacto(Contacto c) {
        boolean eliminado = contactos.remove(c);
        System.out.println(eliminado
                ? "Contacto eliminado correctamente."
                : "Error: el contacto no existe.");
        return eliminado;
    }
    @Override
    public boolean modificarTelefono(String nombre, String apellido, String nuevoTelefono) {
        Contacto contacto = buscaContacto(nombre, apellido);
        if (contacto == null) {
            System.out.println("Error: el contacto no existe.");
            return false;
        }
        contacto.setTelefono(nuevoTelefono);
        System.out.println("Teléfono modificado correctamente.");
        return true;
    }

}
