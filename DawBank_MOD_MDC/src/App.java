import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CuentaBancaria cuenta = null;

        try {
            System.out.print("Ingrese el IBAN: ");
            String iban = scanner.nextLine();
            
            System.out.print("Ingrese el nombre del cliente: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el DNI: ");
            String dni = scanner.nextLine();
            System.out.print("Ingrese la fecha de nacimiento (YYYY-MM-DD): ");
            String fechaNac = scanner.nextLine();
            System.out.print("Ingrese el teléfono: ");
            String telefono = scanner.nextLine();
            System.out.print("Ingrese el email: ");
            String email = scanner.nextLine();
            System.out.print("Ingrese la dirección: ");
            String direccion = scanner.nextLine();

            LocalDate fechaNacimiento = LocalDate.parse(fechaNac);
            Cliente cliente = new Cliente(nombre, dni, fechaNacimiento, telefono, email, direccion);
            cuenta = new CuentaBancaria(iban, cliente);

        } catch (Exception e) {
            System.out.println("Error al crear la cuenta: " + e.getMessage());
            e.printStackTrace();
            return;
        }

        int opcion = -1;
        while (opcion != 8) {
            try {
                System.out.println("\n=== MENÚ PRINCIPAL ===");
                System.out.println("1. Datos de la cuenta");
                System.out.println("2. Ver IBAN");
                System.out.println("3. Ver titular");
                System.out.println("4. Ver saldo");
                System.out.println("5. Realizar ingreso");
                System.out.println("6. Realizar retirada");
                System.out.println("7. Ver movimientos");
                System.out.println("8. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println(cuenta.mostrarDatosCuenta());
                        break;
                    case 2:
                        System.out.println("IBAN: " + cuenta.getNumeroCuenta());
                        break;
                    case 3:
                        System.out.println("Titular: " + cuenta.getCliente().toString());
                        break;
                    case 4:
                        System.out.println("Saldo disponible: " + cuenta.getSaldo() + " euros");
                        break;
                    case 5:
                        System.out.print("Ingrese la cantidad a depositar: ");
                        double ingreso = scanner.nextDouble();
                        scanner.nextLine();
                        try {
                            cuenta.ingresar(ingreso);
                            System.out.println("Ingreso realizado con éxito");
                        } catch (AvisarHaciendaException e) {
                            System.out.println("Operación realizada, pero requiere notificación a Hacienda");
                            System.out.println(e.getMessage());
                            e.printStackTrace();
                        }
                        break;
                    case 6:
                        System.out.print("Ingrese la cantidad a retirar: ");
                        double retiro = scanner.nextDouble();
                        scanner.nextLine();
                        try {
                            cuenta.retirar(retiro);
                            System.out.println("Retiro realizado con éxito");
                        } catch (AvisarHaciendaException e) {
                            System.out.println("Operación realizada, pero requiere notificación a Hacienda");
                            System.out.println(e.getMessage());
                            e.printStackTrace();
                        }
                        break;
                    case 7:
                        System.out.println("\n=== HISTORIAL DE MOVIMIENTOS ===");
                        List<Movimiento> movimientos = cuenta.getMovimientos();
                        if (movimientos.isEmpty()) {
                            System.out.println("No hay movimientos registrados.");
                        } else {
                            for (Movimiento mov : movimientos) {
                                System.out.println(mov.toString());
                            }
                        }
                        break;
                    case 8:
                        System.out.println("Gracias por usar DawBank. ¡Hasta pronto!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (CuentaException e) {
                System.out.println("Error en la operación: " + e.getMessage());
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}