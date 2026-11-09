package mx.com.agenda.servicio;

import mx.com.agenda.modelo.Contacto;

import java.util.ArrayList;
import java.util.Collections;

public class Agenda implements OperacionesAgenda {
    private ArrayList<Contacto> contactos;
    private int tamanoMaximo;

    // Constructor por defecto (tamaño 10)
    public Agenda() {
        this(10);
    }

    // Constructor con tamaño personalizado
    public Agenda(int tamanoMaximo) {
        this.tamanoMaximo = tamanoMaximo;
        this.contactos = new ArrayList<>();
    }

    @Override
    public boolean añadirContacto(Contacto c) {
        if (c.getNombre() == null || c.getNombre().isBlank()
                || c.getApellido() == null || c.getApellido().isBlank()) {
            System.out.println("No se puede añadir: el nombre y el apellido no pueden estar vacíos.");
            return false;
        }
        if (agendaLlena()) {
            System.out.println("No se puede añadir el contacto: la agenda está llena.");
            return false;
        }
        if (existeContacto(c)) {
            System.out.println("No se puede añadir: ya existe un contacto con el nombre '"
                    + c.getNombre() + " " + c.getApellido() + "'.");
            return false;
        }
        contactos.add(c);
        System.out.println("Contacto '" + c.getNombre() + " " + c.getApellido() + "' añadido con éxito.");
        return true;
    }

    @Override
    public boolean existeContacto(Contacto c) {
        return contactos.contains(c);
    }

    @Override
    public void listarContactos() {
        System.out.println("\n--- LISTA DE CONTACTOS ---");
        if (contactos.isEmpty()) {
            System.out.println("La agenda está vacía.");
            return;
        }
        Collections.sort(contactos);
        for (Contacto c : contactos) {
            System.out.println(c.mostrarInformacion());
        }
    }

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

    @Override
    public boolean agendaLlena() {
        return contactos.size() >= tamanoMaximo;
    }

    @Override
    public int espacioLibres() {
        return tamanoMaximo - contactos.size();
    }
}
