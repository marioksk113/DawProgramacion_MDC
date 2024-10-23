package com.decroly.daw;

import java.util.Scanner;

public class Ejercicio4_MDC {
    public static void main(String[] args) {
        
    // 1

    Scanner scanner = new Scanner(System.in);

   double [] numeros = new double[10];

    System.out.println("Introduce 10 números reales:");

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextDouble();
        }
        
    System.out.println("\nLos números introducidos son:");

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Número " + (i + 1) + ": " + numeros[i]);
        }


    // 2

   double [] numeros2 = new double[10];

    double suma = 0;

    System.out.println("Introduce los 10 número a sumar");

        for (int i = 0; i < numeros2.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");      
            numeros2[i] = scanner.nextDouble();      
        }

    System.out.println("\nEstos son los numeros a sumar:");

        for (int i = 0; i < numeros2.length; i++) {

            System.out.println("Número" + (i + 1) + ": " + numeros2[i] );

            suma += numeros2[i];
        } 



        System.out.println("La suma de todos ellos da: " + suma); 
    
    // 3

    scanner = new Scanner(System.in);
        
    double[] numeros3 = new double[10];

    System.out.println("Introduce 10 números reales:");
        
    for (int i = 0; i < numeros3.length; i++) {
            
            System.out.print("Número " + (i + 1) + ": ");
            
            numeros3[i] = scanner.nextDouble();
        }

       
        double max = numeros3[0];
        double min = numeros3[0];

        for (int i = 1; i < numeros3.length; i++) {
            if (numeros3[i] > max) {
                max = numeros3[i];
            }
            if (numeros3[i] < min) {
                min = numeros3[i];
            }
        }

        System.out.println("El número máximo es: " + max);
        System.out.println("El número mínimo es: " + min); 

        // 4

        double [] num4 = new double[20];

        double sumapositive = 0;
        double sumanegative = 0;

        System.out.println("Introduce los 20 número a sumar");

            for (int i = 0; i < num4.length; i++) {
                System.out.print("Número " + (i + 1) + ": ");      
                num4[i] = scanner.nextDouble(); 
                
                if ( num4[i] >= 0){
                    sumapositive += num4[i];
                }

                else {
                    sumanegative += num4[i];
                }

            
            }


            



        System.out.println("La suma de todos ellos da: " + sumapositive); 
        System.out.println("La suma de todos ellos da: " + sumanegative); 

        // 5
        
        double [] num5 = new double[20];

        double sumamedia = 0;
        double media = 0;

        System.out.println("Introduce los 20 números para hacer la media");

        for (int i = 0; i < num5.length; i++) {
            
            System.out.print("Número " + (i + 1) + ": ");
            
            num5[i] = scanner.nextDouble();
            
            sumamedia += num5[i]; }

            media = sumamedia / num5.length;
    
    
        System.out.println("La media es: " + media); 
        // 6

        scanner = new Scanner(System.in);

        System.out.println("¿Qué tamaño quieres que tenga el array?");
            int arraySize = scanner.nextInt();

            int[] num6 = new int[arraySize];

        System.out.println("¿Qué dato quieres meter en el array?");
            int m = scanner.nextInt();

        for (int i = 0; i < num6.length; i++) {
            num6[i] = m;
        }

        System.out.println("Datos del array:");
        
        for (int i = 0; i < num6.length; i++) {
            
            System.out.println("Posición " + i + ": " + num6[i]);
        } 


        // 7

        scanner = new Scanner(System.in);

        System.out.println("Introduce P:");
        
            int p = scanner.nextInt();

        System.out.println("Introduce Q:");
        
            int q = scanner.nextInt();

        if (p > q) {
            System.out.println("P debe ser menor o igual a Q.");
            return;
        }

        int[] num7 = new int[q - p + 1];

        for (int i = 0; i < num7.length; i++) {
            num7[i] = p + i;
        }


        for (int i = 0; i < num7.length; i++) {
            
            System.out.println("Posición " + i + ": " + num7[i]);
        }

        // 8 
        
        scanner = new Scanner(System.in);

        double[] num8 = new double[100];

        for (int i = 0; i < num8.length; i++) {
            num8[i] = Math.random();
        }

        double r;
        
        do {
            System.out.println("¿Qué número es R?");
            r = scanner.nextDouble();
        } while (r < 0.0 || r > 1.0);

        System.out.println("Estos son los números generados mayores que " + r + ": ");
        for (int i = 0; i < num8.length; i++) {
            if (num8[i] > r) {
                System.out.println(num8[i]);
            }
        }

        // 9

        int[] array = new int[100];
        scanner = new Scanner(System.in);
        

             for (int i = 0; i < array.length; i++) {
           
                array[i] = 1 + (int) (Math.random() * 10);
            }

        System.out.print("Introduce un valor N (1-10): ");
        int n9 = scanner.nextInt();

        System.out.print("El valor " + n9 + " aparece en las posiciones: ");
            for (int i = 0; i < array.length; i++) {
                if (array[i] == n9) {
                    System.out.print(i + " ");
                }
            }

        // 10

        scanner = new Scanner(System.in);

        System.out.print("Introduce el número de personas: ");
        
        int n10 = scanner.nextInt();
        double[] alturas = new double[n10];

            for (int i = 0; i < n10; i++) {
                System.out.print("Introduce la altura de la persona " + (i + 1) + ": ");
                alturas[i] = scanner.nextDouble();
            }


        double suma10 = 0, max10 = alturas[0], min10 = alturas[0];
            
            for (double altura : alturas) {
                suma10 += altura;
                if (altura > max10) max10 = altura;
                if (altura < min10) min10 = altura;
            }

        double media10 = suma10 / n10;

        int porEncima = 0, porDebajo = 0;
        
            for (double altura : alturas) {
                if (altura > media10) porEncima++;
                if (altura < media10) porDebajo++;
            }

        System.out.println("Altura media: " + media10);
        System.out.println("Altura máxima: " + max10);
        System.out.println("Altura mínima: " + min10);
        System.out.println(porEncima + " personas miden por encima de la media.");
        System.out.println(porDebajo + " personas miden por debajo de la media.");
    
        // 11 

        int[] array1 = new int[100];
        int[] array2 = new int[100];

            for (int i = 0; i < 100; i++) {
                
                array1[i] = i + 1;
            }

            for (int i = 0; i < 100; i++) {
               
                array2[i] = array1[99 - i];
            }

        System.out.println("Array 1:");
        
            for (int i = 0; i < 100; i++) {
                
                System.out.print(array1[i] + " ");
            }

        System.out.println("\nArray 2 (inverso):");
            
            for (int i = 0; i < 100; i++) {
                
                System.out.print(array2[i] + " "); 
            }

        
        // 12

        scanner = new Scanner(System.in);
        int[] array12 = new int[10];
        char option;

        do {
            System.out.println("Menú:");
            System.out.println("a. Mostrar valores");
            System.out.println("b. Introducir valor");
            System.out.println("c. Salir");
            System.out.print("Elige una opción: ");
            option = scanner.next().charAt(0);

            switch (option) {
                case 'a':
                    mostrarValores(array12);
                    break;
                case 'b':
                    System.out.print("Introduce el valor (entero): ");
                    int valor = scanner.nextInt();
                    System.out.print("Introduce la posición (0-9): ");
                    int posicion = scanner.nextInt();

                    if (posicion >= 0 && posicion < array12.length) {
                        array12[posicion] = valor;
                        System.out.println("Valor introducido correctamente.");
                    } else {
                        System.out.println("Posición inválida. Debe estar entre 0 y 9.");
                    }
                    break;
                case 'c':
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }

        } while (option != 'c');
        
    }

    public static void mostrarValores(int[] array12) {
        System.out.println("Valores en el array:");
        for (int i = 0; i < array12.length; i++) {
            System.out.println("Posición " + i + ": " + array12[i]);

        }
    // 13
    Scanner scanner = new Scanner(System.in);

            System.out.print("Introduce el valor inicial (V): ");
        int vV = scanner.nextInt();
        
        System.out.print("Introduce el incremento (I): ");
        int iI = scanner.nextInt();
        
        System.out.print("Introduce el número de valores a crear (N): ");
        int nN = scanner.nextInt();

        int[] secuencia = new int[nN];

        for (int i = 0; i < secuencia.length; i++) {
            secuencia[i] = vV + i * iI;

        System.out.println("La secuencia aritmética es:");
        for (int valor : secuencia) {
            System.out.print(valor + " ");
        }
        System.out.println();

        }

    // 14

    int nN14 = 10;
        int totalValores = 0;

        for (int i = 1; i <= nN14; i++) {
            totalValores += i;
        }

        int[] secuencia14 = new int[totalValores];
        int index = 0;

        for (int i = 1; i <= nN14; i++) {
            for (int j = 0; j < i; j++) {
                secuencia14[index] = i;
                index++;
            }
        }

        System.out.println("La secuencia es:");
        for (int valor : secuencia14) {
            System.out.print(valor + " ");
        }
        System.out.println();
    }


}


