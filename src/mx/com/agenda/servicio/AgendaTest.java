package mx.com.agenda.servicio;

import mx.com.agenda.modelo.Contacto;

public class AgendaTest {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("INICIANDO PRUEBAS UNITARIAS DE LA AGENDA");
        System.out.println("==================================================");

        Agenda agenda = new Agenda(5);

        Contacto c1 = new Contacto("Checo Perez", "5512345678");
        Contacto c2 = new Contacto("Max Verstappen", "5587654321");
        Contacto c3 = new Contacto("CHECO PEREZ", "5567075432");
        Contacto c4 = new Contacto("Charles Leclerc", "5544443333");
        Contacto c5 = new Contacto("Lewis Hamilton", "5599998888");

        System.out.println("\n🔹 [TEST 1] Añadiendo contactos iniciales:");
        agenda.añadirContacto(c1);
        agenda.añadirContacto(c2);

        System.out.println("\n🔹 [TEST 2] Intentando añadir un duplicado (Mismo nombre en mayúsculas):");
        agenda.añadirContacto(c3);

        System.out.println("\n🔹 [TEST 3] Verificando espacios libres:");
        System.out.println("Espacios libres restantes: " + agenda.espacioLibre());
        System.out.println("¿Agenda llena?: " + (agenda.agendaLlena() ? "SÍ" : "NO"));

        agenda.añadirContacto(c4);

        System.out.println("\n🔹 [TEST 3.1] Verificando límites con la agenda totalmente llena:");
        System.out.println("Espacios libres restantes: " + agenda.espacioLibre());
        System.out.println("¿Agenda llena?: " + (agenda.agendaLlena() ? "SÍ" : "NO"));

        agenda.añadirContacto(c5);

        System.out.println("\n🔹 [TEST 4] Probando el motor de búsqueda:");
        agenda.buscaContacto("max verstappen");
        agenda.buscaContacto("Fernando Alonso");

        System.out.println("\n🔹 [TEST 5] Visualizando el reporte completo de la agenda:");
        agenda.listarContactos();

        System.out.println("\n🔹 [TEST 6] Eliminando un elemento de la agenda:");
        agenda.eliminarContacto(c2);

        System.out.println("\n🔹 [TEST 6.1] Verificando espacios después de la eliminación:");
        System.out.println("Espacios libres actuales: " + agenda.espacioLibre());
        agenda.listarContactos();

        System.out.println("\n==================================================");
        System.out.println("🎉 PRUEBAS FINALIZADAS CON ÉXITO");
        System.out.println("==================================================");
    }
}
