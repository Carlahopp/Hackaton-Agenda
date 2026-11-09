package mx.com.agenda.servicio;

import mx.com.agenda.modelo.Contacto;

public interface OperacionesAgenda {
    void añadirContacto(Contacto c);
    boolean existeContacto(Contacto c);
    void listarContactos();
    void buscaContacto(String nombre);
    void eliminarContacto(Contacto c);
    boolean agendaLlena();
    int espacioLibre();
}
