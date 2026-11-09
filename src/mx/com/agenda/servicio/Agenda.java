package mx.com.agenda.servicio;

import mx.com.agenda.modelo.Contacto;

public class Agenda implements OperacionesAgenda {
    private Contacto[] contactos;
    private int contadorContactos;

    // Constructor por defecto (Tamaño 10)
    public Agenda() {
        this.contactos = new Contacto[10];
        this.contadorContactos = 0;
    }

    // Constructor con tamaño personalizado
    public Agenda(int tamaño) {
        this.contactos = new Contacto[tamaño];
        this.contadorContactos = 0;
    }

    @Override
    public void añadirContacto(Contacto c) {
        if (agendaLlena()) {
            System.out.println("No se puede añadir el contacto: La agenda está llena.");
            return;
        }
        if (existeContacto(c)) {
            System.out.println("No se puede añadir: Ya existe un contacto con el nombre '" + c.getNombre() + "'.");
            return;
        }

        // Añadir en la primera posición libre disponible
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) {
                contactos[i] = c;
                contadorContactos++;
                System.out.println("Contacto '" + c.getNombre() + "' añadido con éxito.");
                return;
            }
        }
    }

    @Override
    public boolean existeContacto(Contacto c) {
        if (c == null || c.getNombre() == null) return false;

        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].getNombre() != null) {
                if (contactos[i].getNombre().equalsIgnoreCase(c.getNombre())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void listarContactos() {
        System.out.println("\n--- LISTA DE CONTACTOS ---");
        boolean hayContactos = false;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null) {
                System.out.println("- Nombre: " + contactos[i].getNombre() + " | Teléfono: " + contactos[i].getTelefono());
                hayContactos = true;
            }
        }
        if (!hayContactos) {
            System.out.println("La agenda está vacía.");
        }
    }

    public void buscaContacto(String nombre) {
        if (nombre == null) return;

        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Contacto encontrado -> Teléfono: " + contactos[i].getTelefono());
                return;
            }
        }
        System.out.println("El contacto '" + nombre + "' no existe en la agenda.");
    }

    public void eliminarContacto(Contacto c) {
        if (c == null || c.getNombre() == null) return;

        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] != null && contactos[i].getNombre().equalsIgnoreCase(c.getNombre())) {
                contactos[i] = null;
                contadorContactos--;
                System.out.println("El contacto '" + c.getNombre() + "' se ha eliminado de la agenda.");
                return;
            }
        }
        System.out.println("No se pudo eliminar: El contacto no se encuentra en la agenda.");
    }

    @Override
    public boolean agendaLlena() {
        return contadorContactos >= contactos.length;
    }

    @Override
    public int espacioLibre() {
        return contactos.length - contadorContactos;
    }
}
