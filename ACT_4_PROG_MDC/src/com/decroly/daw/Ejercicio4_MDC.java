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

    System.out.println("/nEstos son los numeros a sumar:");

        for (int i = 0; i < numeros2.length; i++) {

            System.out.println("Número" + (i + 1) + ": " + numeros2[i] );

            suma += numeros2[i];
        } 



        System.out.println("La suma de todos ellos da: " + suma);
    }   

}
