import java.time.LocalDate;
import java.util.Scanner;

public class GestionVideoDaw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VideoDaw videoClub;

        // Inicializar el videoclub
        System.out.println("=== Bienvenido a VideoDAW ===");
        System.out.print("Introduce el CIF del videoclub: ");
        String cif = scanner.nextLine();

        System.out.print("Introduce la dirección del videoclub: ");
        String direccion = scanner.nextLine();

        videoClub = new VideoDaw(cif, direccion);
        System.out.println("Videoclub creado con éxito.");

        int opcion;

        // Menú principal
        do {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Registrar película en el videoclub");
            System.out.println("2. Crear y registrar cliente en el videoclub");
            System.out.println("3. Alquilar película");
            System.out.println("4. Devolver película");
            System.out.println("5. Mostrar películas registradas");
            System.out.println("6. Mostrar clientes registrados");
            System.out.println("7. Dar de baja cliente");
            System.out.println("8. Salir");

            System.out.print("Selecciona una opción: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Introduce el título de la película: ");
                    String titulo = scanner.nextLine().toUpperCase();

                    System.out.println("Selecciona el género:");
                    for (Genero genero : Genero.values()) {
                        System.out.println(genero.ordinal() + 1 + ". " + genero);
                    }
                    int generoSeleccionado;
                    do {
                        System.out.print("Introduce el número del género: ");
                        generoSeleccionado = scanner.nextInt();
                    } while (generoSeleccionado < 1 || generoSeleccionado > Genero.values().length);

                    Genero genero = Genero.values()[generoSeleccionado - 1];
                    Pelicula pelicula = new Pelicula(titulo, genero);
                    videoClub.registrarPelicula(pelicula);
                }
                case 2 -> {
                    System.out.print("Introduce el DNI del cliente: ");
                    String dni = scanner.nextLine();

                    System.out.print("Introduce el nombre del cliente: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Introduce la dirección del cliente: ");
                    String direccionCliente = scanner.nextLine();

                    System.out.print("Introduce la fecha de nacimiento (YYYY-MM-DD): ");
                    LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());

                    Cliente cliente = new Cliente(dni, nombre, direccionCliente, fechaNacimiento);
                    videoClub.registrarCliente(cliente);
                }
                case 3 -> {
                    System.out.print("Introduce el título de la película a alquilar: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Introduce el DNI del cliente que alquila: ");
                    String dni = scanner.nextLine();

                    videoClub.alquilarPelicula(titulo, dni);
                }
                case 4 -> {
                    System.out.print("Introduce el título de la película a devolver: ");
                    String titulo = scanner.nextLine();

                    videoClub.devolverPelicula(titulo);
                }
                case 5 -> videoClub.mostrarPeliculasRegistradas();
                case 6 -> videoClub.mostrarClientesRegistrados();
                case 7 -> {
                    System.out.print("Introduce el DNI del cliente a dar de baja: ");
                    String dni = scanner.nextLine();

                    Cliente cliente = null;
                    for (Cliente c : videoClub.getClientesRegistrados()) {
                        if (c != null && c.getDni().equals(dni)) {
                            cliente = c;
                            break;
                        }
                    }

                    if (cliente != null) {
                        videoClub.darBajaCliente(cliente);
                        System.out.println("Cliente dado de baja con éxito.");
                    } else {
                        System.out.println("No se encontró un cliente con ese DNI.");
                    }
                }
                case 8 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 8);

        System.out.println("¡Gracias por usar VideoDAW! Hasta pronto.");
        scanner.close();
    }
}
