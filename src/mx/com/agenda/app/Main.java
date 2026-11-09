package mx.com.agenda.app;

import mx.com.agenda.modelo.Contacto;
import mx.com.agenda.servicio.Agenda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = crearAgenda(scanner);
        String opcion;

        do {
            System.out.println("\n===== AGENDA DE CONTACTOS =====");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Comprobar si existe un contacto");
            System.out.println("3. Listar contactos");
            System.out.println("4. Buscar contacto");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Modificar teléfono");
            System.out.println("7. ¿La agenda está llena?");
            System.out.println("8. Espacios libres");
            System.out.println("0. Salir");
            opcion = leer(scanner, "Elige una opción: ");

            switch (opcion) {
                case "1" -> {
                    String nombre = leer(scanner, "Nombre: ");
                    String apellido = leer(scanner, "Apellido: ");
                    String telefono = leer(scanner, "Teléfono: ");
                    agenda.añadirContacto(new Contacto(nombre, apellido, telefono));
                }
                case "2" -> {
                    String nombre = leer(scanner, "Nombre: ");
                    String apellido = leer(scanner, "Apellido: ");
                    if (agenda.existeContacto(new Contacto(nombre, apellido, ""))) {
                        System.out.println("Sí, el contacto existe en la agenda.");
                    } else {
                        System.out.println("No, el contacto no existe en la agenda.");
                    }
                }
                case "3" -> agenda.listarContactos();
                case "4" -> {
                    String nombre = leer(scanner, "Nombre: ");
                    String apellido = leer(scanner, "Apellido: ");
                    Contacto encontrado = agenda.buscaContacto(nombre, apellido);
                    if (encontrado == null) {
                        System.out.println("No se ha encontrado el contacto.");
                    } else {
                        System.out.println("Teléfono: " + encontrado.getTelefono());
                    }
                }
                case "5" -> {
                    String nombre = leer(scanner, "Nombre: ");
                    String apellido = leer(scanner, "Apellido: ");
                    agenda.eliminarContacto(new Contacto(nombre, apellido, ""));
                }
                case "6" -> {
                    String nombre = leer(scanner, "Nombre: ");
                    String apellido = leer(scanner, "Apellido: ");
                    String nuevoTelefono = leer(scanner, "Nuevo teléfono: ");
                    agenda.modificarTelefono(nombre, apellido, nuevoTelefono);
                }
                case "7" -> {
                    if (agenda.agendaLlena()) {
                        System.out.println("La agenda está llena, no hay espacio para nuevos contactos.");
                    } else {
                        System.out.println("La agenda todavía tiene espacio.");
                    }
                }
                case "8" -> System.out.println("Puedes añadir " + agenda.espacioLibres() + " contactos más.");
                case "0" -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción no válida, intenta otra vez.");
            }
        } while (!opcion.equals("0"));

        scanner.close();
    }

    // Pregunta el tamaño: si da Enter o escribe algo inválido, se usa el de 10
    private static Agenda crearAgenda(Scanner scanner) {
        String respuesta = leer(scanner, "¿De qué tamaño quieres la agenda? (Enter para 10): ");
        if (respuesta.isBlank()) {
            return new Agenda();
        }
        try {
            int tamano = Integer.parseInt(respuesta.trim());
            if (tamano > 0) {
                return new Agenda(tamano);
            }
        } catch (NumberFormatException e) {
            // no era un número, se usa el tamaño por defecto
        }
        System.out.println("Tamaño no válido, se usará el de 10.");
        return new Agenda();
    }

    // Muestra un mensaje y regresa lo que escriba el usuario
    private static String leer(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }
}