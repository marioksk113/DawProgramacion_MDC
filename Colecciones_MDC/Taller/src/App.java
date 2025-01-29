import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Taller taller = new Taller();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        String entrada;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Añadir coche");
            System.out.println("2. Eliminar coche");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            entrada = scanner.nextLine();

            if (entrada.equals("1") || entrada.equals("2") || entrada.equals("3")) {
                opcion = Integer.parseInt(entrada);
            } else {
                System.out.println("Opción no válida. Por favor, seleccione una opción entre 1 y 3.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la matrícula del coche: ");
                    String matricula = scanner.nextLine();
                    System.out.print("Ingrese la marca del coche: ");
                    String marca = scanner.nextLine();
                    System.out.print("Ingrese el color del coche: ");
                    String color = scanner.nextLine();
                    
                    String resultadoAñadir = taller.añadirCoche(matricula, marca, color);
                    System.out.println(resultadoAñadir);
                    break;

                case 2:
                    System.out.print("Ingrese la matrícula del coche a eliminar: ");
                    String matriculaEliminar = scanner.nextLine();
                    String resultadoEliminar = taller.eliminarCoche(matriculaEliminar);
                    System.out.println(resultadoEliminar);
                    break;

                case 3:
                    System.out.println("\nMatrículas registradas:");
                    for (Map.Entry<String, String> entry : taller.visualizarMatriculas().entrySet()) {
                        System.out.println(entry.getKey());
                    }
                    
                    System.out.println("\nDatos de los coches:");
                    for (Map.Entry<String, String> entry : taller.visualizarCoches().entrySet()) {
                        System.out.println("Marca: " + entry.getKey() + ", Color: " + entry.getValue());
                    }
                    
                    System.out.println("\nDatos completos del taller:");
                    for (Map.Entry<String, String> entry : taller.visualizarTaller().entrySet()) {
                        System.out.println("Matrícula: " + entry.getKey() + " -> " + entry.getValue());
                    }
                    break;
            }
        } while (opcion != 3);

        scanner.close();
    }
}