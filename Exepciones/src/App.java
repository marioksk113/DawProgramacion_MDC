import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class App {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\n=== EJERCICIO 1 ===");
        ejercicio1();

        System.out.println("\n=== EJERCICIO 2 ===");
        ejercicio2();

        System.out.println("\n=== EJERCICIO 3 ===");
        ejercicio3();

        System.out.println("\n=== EJERCICIO 4 ===");
        ejercicio4();

        System.out.println("\n=== EJERCICIO 5 ===");
        ejercicio5();

        System.out.println("\n=== EJERCICIO 6 ===");
        ejercicio6();

        scanner.close();
    }

    // Ejercicio 1
    private static void ejercicio1() {
        try {
            System.out.print("Introduce un valor entero: ");
            int valor = scanner.nextInt();
            System.out.println("Valor introducido: " + valor);
        } catch (InputMismatchException e) {
            System.out.println("Valor introducido incorrecto");
            e.printStackTrace();
            scanner.nextLine();
        }
    }

    // Ejercicio 2
    private static void ejercicio2() {
        try {
            System.out.print("Introduce el primer valor (A): ");
            int a = scanner.nextInt();
            System.out.print("Introduce el segundo valor (B): ");
            int b = scanner.nextInt();
            int resultado = a / b;
            System.out.println("Resultado de " + a + "/" + b + " = " + resultado);
        } catch (InputMismatchException e) {
            System.out.println("Error: Debes introducir números enteros válidos");
            e.printStackTrace();
            scanner.nextLine();
        } catch (ArithmeticException e) {
            System.out.println("Error: No es posible dividir por cero");
            e.printStackTrace();
        }
    }

    // Ejercicio 3
    private static void ejercicio3() {
        double[] vector = new double[5];
        int posicion = 0;

        while (posicion < vector.length) {
            try {
                System.out.print("Introduce el valor " + (posicion + 1) + " de 5: ");
                vector[posicion] = scanner.nextDouble();
                posicion++;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes introducir un número decimal válido");
                e.printStackTrace();
                scanner.nextLine();
            }
        }

        // Mostrar el vector completo
        System.out.println("Vector completo:");
        for (double valor : vector) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }

    // Ejercicio 4
    private static void ejercicio4() {
        int[] valoresPrueba = {5, -3, 0, 10, -8};
        
        for (int valor : valoresPrueba) {
            try {
                System.out.println("\nProbando con valor: " + valor);
                imprimePositivo(valor);
            } catch (Exception e) {
                System.out.println("Error en imprimePositivo: " + e.getMessage());
                e.printStackTrace();
            }

            try {
                imprimeNegativo(valor);
            } catch (Exception e) {
                System.out.println("Error en imprimeNegativo: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private static void imprimePositivo(int p) throws Exception {
        if (p < 0) {
            throw new Exception("El número " + p + " no es positivo");
        }
        System.out.println("Número positivo: " + p);
    }

    private static void imprimeNegativo(int n) throws Exception {
        if (n >= 0) {
            throw new Exception("El número " + n + " no es negativo");
        }
        System.out.println("Número negativo: " + n);
    }

     // Ejercicio 5
     private static void ejercicio5() {
        System.out.println("Pruebas de la clase Gato:");
        
        try {
            // Prueba con valores validos
            System.out.println("\nPrueba 1: Creación con valores válidos");
            Gato gato1 = new Gato("Luna", 5);
            System.out.println(gato1.imprimir());

            // Prueba de setters con valores validos
            System.out.println("\nPrueba 2: Modificación con setters válidos");
            gato1.setNombre("Kitty");
            gato1.setEdad(6);
            System.out.println(gato1.imprimir());

            // Prueba con nombre invalido
            System.out.println("\nPrueba 3: Nombre inválido");
            Gato gato2 = new Gato("Lu", 3);
        } catch (Exception e) {
            System.out.println("Error al crear/modificar gato: " + e.getMessage());
            e.printStackTrace();
        }

        try {
            // Prueba con edad invalida
            System.out.println("\nPrueba 4: Edad inválida");
            Gato gato3 = new Gato("Michi", -1);
        } catch (Exception e) {
            System.out.println("Error al crear gato: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Ejercicio 6
    private static void ejercicio6() {
        ArrayList<Gato> gatos = new ArrayList<>();
        scanner.nextLine();

        System.out.println("Introducción de datos de gatos:");
        while (gatos.size() < 5) {
            try {
                System.out.println("\nGato " + (gatos.size() + 1) + " de 5");
                System.out.print("Introduce el nombre del gato: ");
                String nombre = scanner.nextLine().trim();
                
                System.out.print("Introduce la edad del gato: ");
                String edadStr = scanner.nextLine().trim();
                
                try {
                    int edad = Integer.parseInt(edadStr);
                    Gato gato = new Gato(nombre, edad);
                    gatos.add(gato);
                    System.out.println("Gato añadido correctamente.");
                } catch (NumberFormatException e) {
                    System.out.println("Error: La edad debe ser un número entero válido");
                    e.printStackTrace();
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                e.printStackTrace();
            }
        }

        System.out.println("\nLista de todos los gatos:");
        System.out.println("------------------------");
        for (Gato gato : gatos) {
            System.out.println(gato.imprimir());
        }
    }
}

