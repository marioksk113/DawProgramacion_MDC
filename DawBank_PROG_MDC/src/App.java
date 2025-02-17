import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CuentaBancaria cuenta;

        System.out.print("Ingrese el IBAN: ");
        String iban = scanner.nextLine();
        System.out.print("Ingrese el titular: ");
        String titular = scanner.nextLine();

        cuenta = new CuentaBancaria(iban, titular);

<<<<<<< HEAD
        if (cuenta.getNumerocuenta() == null || cuenta.getTitular() == null) {
=======
        if (cuenta.getNumeroCuenta() == null || cuenta.getTitular() == null) {
>>>>>>> 127d3f7e1d555505177c53819bcbf68334b7bb0e
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
                    cuenta.mostrarDatosCuenta();
                    break;
                case 2:
<<<<<<< HEAD
                    System.out.println("IBAN: " + cuenta.getNumerocuenta());
=======
                    System.out.println("IBAN: " + cuenta.getNumeroCuenta());
>>>>>>> 127d3f7e1d555505177c53819bcbf68334b7bb0e
                    break;
                case 3:
                    System.out.println("Titular: " + cuenta.getTitular());
                    break;
                case 4:
                    System.out.println("Saldo disponible: " + cuenta.getSaldo() + " euros");
                    break;
                case 5:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double ingreso = scanner.nextDouble();
                    scanner.nextLine();
                    cuenta.ingresar(ingreso);
                    break;
                case 6:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double retiro = scanner.nextDouble();
                    scanner.nextLine();
                    cuenta.retirar(retiro);
                    break;
                case 7:
                    cuenta.mostrarMovimientos();
                    break;
                case 8:
                    System.out.println("Gracias por usar DawBank. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
