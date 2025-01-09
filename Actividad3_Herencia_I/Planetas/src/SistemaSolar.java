import java.util.Scanner;

public class SistemaSolar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorSistemaSolar gestor = new GestorSistemaSolar();
        gestor.inicializarDatos();
        
        while (true) {
            System.out.println("\n=== SISTEMA SOLAR ===");
            System.out.println("1. Mostrar información de un astro");
            System.out.println("2. Agregar planeta");
            System.out.println("3. Agregar satélite");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.print(gestor.listarAstros());
                    System.out.print("Seleccione un astro: ");
                    int indice = scanner.nextInt() - 1;
                    System.out.println(gestor.mostrarAstro(indice));
                    break;
                case 2:
                    scanner.nextLine(); // Limpiar buffer
                    System.out.println("\nIngrese los datos del planeta:");
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Masa (kg): ");
                    double masa = scanner.nextDouble();
                    System.out.print("Diámetro (km): ");
                    double diametro = scanner.nextDouble();
                    System.out.print("Periodo de rotación (días): ");
                    double periodoRotacion = scanner.nextDouble();
                    System.out.print("Temperatura media (°C): ");
                    double temperaturaMedia = scanner.nextDouble();
                    System.out.print("Gravedad (m/s²): ");
                    double gravedad = scanner.nextDouble();
                    System.out.print("Distancia al Sol (km): ");
                    double distanciaAlSol = scanner.nextDouble();
                    System.out.print("Periodo de traslación (días): ");
                    double periodoTraslacion = scanner.nextDouble();

                    System.out.println(gestor.agregarPlaneta(nombre, masa, diametro, 
                        periodoRotacion, temperaturaMedia, gravedad, distanciaAlSol, 
                        periodoTraslacion));
                    break;
                case 3:
                    System.out.print(gestor.listarPlanetas());
                    System.out.print("Seleccione el planeta: ");
                    int indicePlaneta = scanner.nextInt() - 1;
                    
                    scanner.nextLine(); // Limpiar buffer
                    System.out.println("\nIngrese los datos del satélite:");
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Masa (kg): ");
                    masa = scanner.nextDouble();
                    System.out.print("Diámetro (km): ");
                    diametro = scanner.nextDouble();
                    System.out.print("Periodo de rotación (días): ");
                    periodoRotacion = scanner.nextDouble();
                    System.out.print("Temperatura media (°C): ");
                    temperaturaMedia = scanner.nextDouble();
                    System.out.print("Gravedad (m/s²): ");
                    gravedad = scanner.nextDouble();
                    System.out.print("Distancia al planeta (km): ");
                    double distanciaAlPlaneta = scanner.nextDouble();
                    System.out.print("Periodo orbital (días): ");
                    double periodoOrbital = scanner.nextDouble();

                    System.out.println(gestor.agregarSatelite(nombre, masa, diametro,
                        periodoRotacion, temperaturaMedia, gravedad, distanciaAlPlaneta,
                        periodoOrbital, indicePlaneta));
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}