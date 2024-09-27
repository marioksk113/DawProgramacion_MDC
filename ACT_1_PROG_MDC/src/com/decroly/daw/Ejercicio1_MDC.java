package com.decroly.daw;

import java.util.Scanner;

public class Ejercicio1_MDC {

    public static void main(String[] args) {

        // 1. Buenos Dias
        System.out.println("Buenos días!");

        // 2. Ladi Fijo
        int ladoFijo = 5;
        int areaCuadradoFijo = ladoFijo * ladoFijo;
        System.out.println("El área del cuadrado de lado "+ladoFijo +" es: " + areaCuadradoFijo);

        // 3. Lado Manual
        System.out.print("Lado del cuadrado: ");
        Scanner scanner = new Scanner(System.in);
        int lado = scanner.nextInt();
        int areaCuadrado = lado * lado;
        System.out.println("El area es: " + areaCuadrado);
        
        // Mates 
       int num1 = 20;
       int num2 = 2;
       int suma = num1 + num2;
       int resta = num1 - num2;
       int producto = num1 * num2;
       int division = num1 / num2;
       System.out.println(suma);
       System.out.println(resta);
       System.out.println(producto);
       System.out.println(division);

    	}
    }