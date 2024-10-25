import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
    
    // 1

        int[][] matriz1 = new int[5][5];
        int contador = 1;

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    matriz1[i][j] = contador++;
                }
            }

            for (int[] fila : matriz1) {
                for (int num : fila) {
                    System.out.print(num + "\t");
                }
                System.out.println();
            }


    // 2

        int[][] matriz2 = new int[10][10];
    
            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j <= 10; j++) {
                    matriz2[i - 1][j - 1] = i * j;
                }
            }
    
            for (int[] fila : matriz2) {
                for (int num : fila) {
                    System.out.print(num + "\t");
                }
                System.out.println();
            }



    // 3
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el número de filas (N): ");
            
        int n = scanner.nextInt();
            
        System.out.print("Introduce el número de columnas (M): ");
            
        int m = scanner.nextInt();

        int[][] matriz3 = new int[n][m];
        int mayores = 0, menores = 0, ceros = 0;

        System.out.println("Introduce los valores de la matriz:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matriz3[i][j] = scanner.nextInt();
                    if (matriz3[i][j] > 0) {
                        mayores++;
                    } else if (matriz3[i][j] < 0) {
                        menores++;
                    } else {
                        ceros++;
                    }
                }
            }

        System.out.println("Valores mayores que cero: " + mayores);
        System.out.println("Valores menores que cero: " + menores);
        System.out.println("Valores iguales a cero: " + ceros);
    
    // 4
    
        scanner = new Scanner(System.in);
        
        String[] alumnos = {"Alumno 1", "Alumno 2", "Alumno 3", "Alumno 4"};
        
        int numAsignaturas = 5;
        
        double[][] notas = new double[4][numAsignaturas];

            for (int i = 0; i < 4; i++) {
                System.out.println("Introduce las notas para " + alumnos[i] + ":");
                for (int j = 0; j < numAsignaturas; j++) {
                    System.out.print("Nota de asignatura " + (j + 1) + ": ");
                    notas[i][j] = scanner.nextDouble();
                }
            }

            for (int i = 0; i < 4; i++) {
                double min = Double.MAX_VALUE, max = Double.MIN_VALUE, suma = 0;
                for (int j = 0; j < numAsignaturas; j++) {
                    if (notas[i][j] < min) min = notas[i][j];
                    if (notas[i][j] > max) max = notas[i][j];
                    suma += notas[i][j];
                }
                double media = suma / numAsignaturas;
                System.out.println(alumnos[i] + " - Nota mínima: " + min + ", Máxima: " + max + ", Media: " + media);
            } 
    
    // 5

    scanner = new Scanner(System.in);
    System.out.print("Introduce el número de personas: ");
    int n5 = scanner.nextInt();

    int[][] datos = new int[n5][2];
    double sueldoHombres = 0, sueldoMujeres = 0;
    int contHombres = 0, contMujeres = 0;

        for (int i = 0; i < n5; i++) {
            System.out.print("Introduce el género (0 para varón, 1 para mujer) de la persona " + (i + 1) + ": ");
            datos[i][0] = scanner.nextInt();
            System.out.print("Introduce el sueldo de la persona " + (i + 1) + ": ");
            datos[i][1] = scanner.nextInt();

            if (datos[i][0] == 0) {
                sueldoHombres += datos[i][1];
                contHombres++;
            } else {
                sueldoMujeres += datos[i][1];
                contMujeres++;
            }
        }

    double mediaHombres = (contHombres > 0) ? sueldoHombres / contHombres : 0;
    double mediaMujeres = (contMujeres > 0) ? sueldoMujeres / contMujeres : 0;

    System.out.println("Sueldo medio de hombres: " + mediaHombres);
    System.out.println("Sueldo medio de mujeres: " + mediaMujeres);

        if (mediaHombres > mediaMujeres) {
            System.out.println("Existe brecha salarial a favor de los hombres.");
        } else if (mediaHombres < mediaMujeres) {
            System.out.println("Existe brecha salarial a favor de las mujeres.");
        } else {
            System.out.println("No existe brecha salarial.");
        }

    }


 }
    
