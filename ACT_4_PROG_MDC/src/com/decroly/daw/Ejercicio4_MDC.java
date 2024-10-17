package com.decroly.daw;

import java.util.Scanner;

public class Ejercicio4_MDC {
    public static void main(String[] args) {
        
    // 1

    Scanner scanner = new Scanner(System.in);

    /**double [] numeros = new double[10];

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
        } **/

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


    }


}
