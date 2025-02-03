import java.util.LinkedList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcion;

        do {
            System.out.println("\n=== MENÚ AGENDA ===");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Buscar contacto");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Visualizar agenda");
            System.out.println("5. Número de contactos de mi agenda");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Introduce el teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Introduce el correo: ");
                    String correo = scanner.nextLine();
                    
                    int resultado = agenda.añadirContacto(nombre, telefono, correo);
                    switch(resultado) {
                        case 0:
                            System.out.println("Contacto añadido correctamente");
                            break;
                        case 1:
                            System.out.println("Nombre no válido");
                            break;
                        case 2:
                            System.out.println("Teléfono no válido");
                            break;
                        case 3:
                            System.out.println("Correo no válido");
                            break;
                        case 4:
                            System.out.println("Ya existe un contacto con ese nombre");
                            break;
                    }
                    break;
                case 2:
                    System.out.print("Introduce el nombre del contacto a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    Contacto contactoEncontrado = agenda.buscarContacto(nombreBuscar);
                    if (contactoEncontrado != null) {
                        System.out.println("Nombre: " + contactoEncontrado.getNombre());
                        System.out.println("Teléfono: " + contactoEncontrado.getTelefono());
                        System.out.println("Correo: " + contactoEncontrado.getCorreo());
                    } else {
                        System.out.println("No se encontró el contacto");
                    }
                    break;
                case 3:
                    System.out.print("Introduce el nombre del contacto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    boolean eliminado = agenda.eliminarContacto(nombreEliminar);
                    if (eliminado) {
                        System.out.println("Contacto eliminado correctamente");
                    } else {
                        System.out.println("No se encontró el contacto");
                    }
                    break;
                case 4:
                    if (agenda.agendaVacia()) {
                        System.out.println("La agenda está vacía");
                    } else {
                        LinkedList<Contacto> contactos = agenda.obtenerContactos();
                        for (Contacto c : contactos) {
                            System.out.println("Nombre: " + c.getNombre());
                            System.out.println("Teléfono: " + c.getTelefono());
                            System.out.println("Correo: " + c.getCorreo());
                            System.out.println("-------------------");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Número de contactos: " + agenda.numeroContactos());
                    break;
                case 6:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 6);
        
        scanner.close();
    }
}