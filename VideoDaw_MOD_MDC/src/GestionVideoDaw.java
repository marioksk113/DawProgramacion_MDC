import java.time.LocalDate;
import java.util.Scanner;

public class GestionVideoDaw {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VideoDaw videoClub = null;
        Utilidades utilidades = new Utilidades();
        int opcion;

        System.out.println("=== Bienvenido a VideoDAW ===");

        // Menú principal
        do {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Crear y registrar VideoClub en la franquicia.");
            System.out.println("2. Registrar película en videoclub.");
            System.out.println("3. Crear y registrar cliente en videoclub.");
            System.out.println("4. Alquilar.");
            System.out.println("5. Devolver.");
            System.out.println("6. Dar de baja cliente.");
            System.out.println("7. Dar de baja articulo.");
            System.out.println("8. Salir.");

            System.out.print("Selecciona una opción: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine();

            // Verificar que el videoclub esté creado para opciones 2-7
            if (opcion >= 2 && opcion <= 7 && videoClub == null) {
                System.out.println("Error: Primero debes crear el videoclub (opción 1).");
                continue;
            }

            switch (opcion) {
                case 1 -> {
                    if (videoClub != null) {
                        System.out.println("Ya existe un videoclub creado.");
                        videoClub.mostrarInfoVideoClub();
                    } else {
                        System.out.print("Introduce el CIF del videoclub: ");
                        String cif = scanner.nextLine();

                        System.out.print("Introduce la dirección del videoclub: ");
                        String direccion = scanner.nextLine();

                        videoClub = new VideoDaw(cif, direccion);
                        System.out.println("Videoclub creado con éxito.");
                    }
                }
                case 2 -> {
                    System.out.print("Introduce el título de la película: ");
                    String titulo = scanner.nextLine();

                    System.out.println("Selecciona el género:");
                    for (Genero genero : Genero.values()) {
                        System.out.println(genero.ordinal() + 1 + ". " + genero);
                    }
                    int generoSeleccionado;
                    do {
                        System.out.print("Introduce el número del género: ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("Por favor, introduce un número válido.");
                            scanner.next();
                        }
                        generoSeleccionado = scanner.nextInt();
                    } while (generoSeleccionado < 1 || generoSeleccionado > Genero.values().length);
                    scanner.nextLine();

                    Genero genero = Genero.values()[generoSeleccionado - 1];
                    Pelicula pelicula = new Pelicula(titulo, genero);
                    String mensaje = videoClub.registrarPelicula(pelicula);
                    System.out.println(mensaje);
                }
                case 3 -> {
                    String dni;
                    do {
                        System.out.print("Introduce el DNI del cliente (formato: 12345678A): ");
                        dni = scanner.nextLine();
                        if (!Utilidades.validarDNI(dni)) {
                            System.out.println("DNI no válido. Inténtalo de nuevo.");
                        }
                    } while (!Utilidades.validarDNI(dni));

                    System.out.print("Introduce el nombre del cliente: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Introduce la dirección del cliente: ");
                    String direccionCliente = scanner.nextLine();

                    LocalDate fechaNacimiento;
                    String fechaTexto;
                    do {
                        System.out.print("Introduce la fecha de nacimiento (YYYY-MM-DD): ");
                        fechaTexto = scanner.nextLine();
                        if (!Utilidades.validarFecha(fechaTexto)) {
                            System.out.println("Formato de fecha no válido. Inténtalo de nuevo.");
                        }
                    } while (!Utilidades.validarFecha(fechaTexto));
                    fechaNacimiento = LocalDate.parse(fechaTexto);

                    try {
                        Cliente cliente = new Cliente(dni, nombre, direccionCliente, fechaNacimiento);
                        try {
                            String mensaje = videoClub.registrarCliente(cliente);
                            System.out.println(mensaje);
                        } catch (ClienteDuplicadoException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.print("Introduce el título de la película a alquilar: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Introduce el DNI del cliente que alquila: ");
                    String dni = scanner.nextLine();

                    try {
                        String mensaje = videoClub.alquilarPelicula(titulo, dni);
                        System.out.println(mensaje);
                    } catch (ClienteBajaException | ArticuloBajaException | ArticuloAlquiladoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 5 -> {
                    System.out.print("Introduce el título de la película a devolver: ");
                    String titulo = scanner.nextLine();

                    try {
                        String mensaje = videoClub.devolverPelicula(titulo);
                        System.out.println(mensaje);
                    } catch (TiempoExcedidoException e) {
                        System.out.println("AVISO DE PENALIZACIÓN: " + e.getMessage());
                        System.out.println("Se aplicará un recargo por devolución tardía.");
                        System.out.println("Película devuelta con éxito, pero con penalización.");
                    }
                }
                case 6 -> {
                    System.out.print("Introduce el DNI del cliente a dar de baja: ");
                    String dni = scanner.nextLine();

                    String mensaje = videoClub.darBajaCliente(dni);
                    System.out.println(mensaje);
                }
                case 7 -> {
                    System.out.print("Introduce el título de la película a dar de baja: ");
                    String titulo = scanner.nextLine();

                    String mensaje = videoClub.darBajaPelicula(titulo);
                    System.out.println(mensaje);
                }
                case 8 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 8);

        System.out.println("¡Gracias por usar VideoDAW! Hasta pronto.");
        scanner.close();
    }
}