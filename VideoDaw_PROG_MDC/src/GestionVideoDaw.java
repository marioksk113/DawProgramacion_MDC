import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GestionVideoDaw {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VideoDaw videoClub = null;
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== Menú Principal ===");
            System.out.println("1. Crear VideoClub");
            System.out.println("2. Registrar película");
            System.out.println("3. Registrar cliente");
            System.out.println("4. Alquilar película");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el CIF: ");
                    String cif = scanner.nextLine();
                    System.out.print("Ingrese la dirección: ");
                    String direccionvideoclub = scanner.nextLine();
                    videoClub = new VideoDaw(cif, direccionvideoclub, LocalDate.now());
                    System.out.println("VideoClub creado.");
                    break;

                case 2:
                    if (videoClub == null) {
                        System.out.println("Debe crear un VideoClub primero.");
                        break;
                    }
                    System.out.print("Ingrese el título de la película: ");
                    String titulo = scanner.nextLine();
                    System.out.println("Seleccione un género (1: DRAMA, 2: TERROR, 3: ACCION, 4: COMEDIA, 5: FANTASIA, 6: AVENTURA):");
                    int generoenum = scanner.nextInt();
                    scanner.nextLine();

                    Genero genero = null;

                    if (generoenum == 1) {
                        genero = Genero.DRAMA;
                    } else if (generoenum == 2) {
                        genero = Genero.TERROR;
                    } else if (generoenum == 3) {
                        genero = Genero.ACCION;
                    } else if (generoenum == 4) {
                        genero = Genero.COMEDIA;
                    } else if (generoenum == 5) {
                        genero = Genero.FANTASIA;
                    } else if (generoenum == 6) {
                        genero = Genero.AVENTURA;
                    } else {
                        System.out.println("Opción de género inválida.");
                        break;
                    }

                    Pelicula pelicula = new Pelicula(titulo, genero);
                    videoClub.registrarPelicula(pelicula);
                    System.out.println("Película registrada.");
                    break;


                case 3:
                    if (videoClub == null) {
                        System.out.println("Debe crear un VideoClub primero.");
                        break;
                    }
                    System.out.print("Ingrese el DNI del cliente: ");
                    String dni = scanner.nextLine();
                    System.out.print("Ingrese el nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la Dirección: ");
                    String direccion = scanner.nextLine();
                    System.out.print("Ingrese la Fecha de Nacimiento en formato YYYY-MM-DD: ");
                    String fechaNacimientoStr = scanner.nextLine();
                
                    if (fechaNacimientoStr.matches("\\d{4}-\\d{2}-\\d{2}")) {
                        LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        Cliente cliente = new Cliente(dni, nombre, direccion, fechaNacimiento);
                        videoClub.registrarCliente(cliente);
                        System.out.println("Cliente registrado.");
                    } else {
                        System.out.println("Formato de fecha inválido. Use el formato yyyy-MM-dd.");
                    }
                    break;

                case 4:
                    if (videoClub == null) {
                        System.out.println("Debe crear un VideoClub primero.");
                        break;
                    }
                    System.out.print("Ingrese el título de la película a alquilar: ");
                    String tituloPelicula = scanner.nextLine();
                    System.out.print("Ingrese el DNI del cliente: ");
                    String dniCliente = scanner.nextLine();
                    System.out.println("Acción de alquiler realizada.");
                    break;

                case 5:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

    }
}
