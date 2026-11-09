package mx.com.agenda.servicio;
import mx.com.agenda.modelo.Contacto;

public interface OperacionesAgenda {

    /*Añade un contacto */
    boolean anadirContacto(Contacto c);

    /* Indica si ya existe un contacto */
    boolean existeContacto(Contacto c);

    /* Muestra los contactos ordenados. */
    void listarContactos();

    /* Busca por nombre y apellido; devuelve null si no existe. */
    Contacto buscaContacto(String nombre, String apellido);

    /* Elimina un contacto; devuelve true si se eliminó. */
    boolean eliminarContacto(Contacto c);

    /* Cambia el teléfono de un contacto existente. */
    boolean modificarTelefono(String nombre, String apellido, String nuevoTelefono);

    /* Indica si ya no caben más contactos. */
    boolean agendaLlena();

    /* Número de contactos que aún se pueden añadir. */
    int espacioLibres();
}
