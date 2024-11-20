import java.util.Scanner;

public class App {

    private CuentaBancaria cuenta;
    private Scanner scanner;

    public App() {
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.print("Ingrese el IBAN: ");
        String iban = scanner.nextLine();
        System.out.print("Ingrese el titular: ");
        String titular = scanner.nextLine();

        this.cuenta = new CuentaBancaria(iban, titular);

        if (cuenta.getIban() == null || cuenta.getTitular() == null) {
            System.out.println("No se pudo crear la cuenta. Verifique los datos ingresados.");
            return;
        }

        int opcion = -1;
        while (opcion != 8) {
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
                    mostrarDatosCuenta();
                    break;
                case 2:
                    System.out.println("IBAN: " + cuenta.getIban());
                    break;
                case 3:
                    System.out.println("Titular: " + cuenta.getTitular());
                    break;
                case 4:
                    System.out.println("Saldo disponible: " + cuenta.getSaldo() + " euros");
                    break;
                case 5:
                    realizarIngreso();
                    break;
                case 6:
                    realizarRetirada();
                    break;
                case 7:
                    mostrarMovimientos();
                    break;
                case 8:
                    System.out.println("Gracias por usar DawBank. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

    }

    private void mostrarDatosCuenta() {
        System.out.println("\n=== DATOS DE LA CUENTA ===");
        System.out.println("IBAN: " + cuenta.getIban());
        System.out.println("Titular: " + cuenta.getTitular());
        System.out.println("Saldo: " + cuenta.getSaldo() + " euros");
    }

    private void realizarIngreso() {
        System.out.print("Ingrese la cantidad a depositar: ");
        double cantidad = scanner.nextDouble();
        scanner.nextLine();
        cuenta.ingresar(cantidad);
    }

    private void realizarRetirada() {
        System.out.print("Ingrese la cantidad a retirar: ");
        double cantidad = scanner.nextDouble();
        scanner.nextLine();
        cuenta.retirar(cantidad);
    }

    public void mostrarMovimientos() {
        System.out.println("\n=== HISTORIAL DE MOVIMIENTOS ===");
        if (cuenta.getTotalMovimientos() == 0) {
            System.out.println("No hay movimientos registrados.");
            return;
        }

        Movimiento[] movimientos = cuenta.getMovimientos();
        for (int i = 0; i < cuenta.getTotalMovimientos(); i++) {
            System.out.println(movimientos[i].infoMovimientoString());
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.iniciar();
    }
}
