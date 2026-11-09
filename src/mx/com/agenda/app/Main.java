package mx.com.agenda.app;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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
            System.out.print("Elige una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1" -> System.out.println("Pendiente: añadir");
                case "2" -> System.out.println("Pendiente: existe");
                case "3" -> System.out.println("Pendiente: listar");
                case "4" -> System.out.println("Pendiente: buscar");
                case "5" -> System.out.println("Pendiente: eliminar");
                case "6" -> System.out.println("Pendiente: modificar");
                case "7" -> System.out.println("Pendiente: llena");
                case "8" -> System.out.println("Pendiente: espacios");
                case "0" -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción no válida, intenta otra vez.");
            }
        } while (!opcion.equals("0"));

        scanner.close();
    }
}