package com.decroly.daw;

import java.util.Scanner;

public class Ejercicio1_MDC {

    public static void main(String[] args) {

        // 1. Buenos Dias
        System.out.println("Buenos días!");

        // 2. Lado Fijo
        int ladoFijo = 5;
        int areaCuadradoFijo = ladoFijo * ladoFijo;
        
        System.out.println("El área del cuadrado de lado "+ladoFijo +" es: " + areaCuadradoFijo);

        // 3. Lado Manual
        System.out.print("Lado del cuadrado: ");
        Scanner scanner = new Scanner(System.in);
        
        int lado = scanner.nextInt();
        int areaCuadrado = lado * lado;
        
        System.out.println("El area es: " + areaCuadrado);
        
        // 4. Mates 
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
       
        // 5.Radio
        scanner = new Scanner(System.in);
        
        System.out.print("Introduce el radio: ");
        
        double radio = scanner.nextDouble();
        double pi = Math.PI;
        double longCircunferencia = 2 * pi * radio;
        double areaCirculo = pi * Math.pow(radio, 2);
        double volumenEsfera = (4.0 / 3.0) * pi * Math.pow(radio, 3);

        System.out.println("Longitud de la circunferencia: " + longCircunferencia);
        System.out.println("Área del círculo: " + areaCirculo);
        System.out.println("Volumen de la esfera: " + volumenEsfera);

        // 6.Descuento
        scanner = new Scanner(System.in);

        System.out.print("Introduce el precio original del artículo: ");
        
        double precioOriginal = scanner.nextDouble();

        System.out.print("Introduce el precio de venta real: ");
        
        double precioVenta = scanner.nextDouble();
        double Descuento = ((precioOriginal - precioVenta) / precioOriginal) * 100;
        
        System.out.println("El porcentaje de descuento es: " + Descuento + "%");

        // 7. Millas a metros
        scanner = new Scanner(System.in);
        
        System.out.println("Cuantas millas hay que pasar a metros colega: ");
        
        double Millas = scanner.nextDouble();
        double Metros = Millas * 1852;
        
        System.out.println("Estas son tus millas en metros" + Metros);
        
        // 8. Orden Ascendente
        scanner = new Scanner(System.in);

        System.out.print("Introduce el primer número: ");
        int nume1 = scanner.nextInt();

        System.out.print("Introduce el segundo número: ");
        int nume2 = scanner.nextInt();

        int menor = Math.min(nume1, nume2);
        int mayor = Math.max(nume1, nume2);

        System.out.println("Los números en orden ascendente son: " + menor + " y " + mayor);
        
        // 9. Mayor o igual
        scanner = new Scanner(System.in);
 
        System.out.print("Introduce el primer número: ");
        int numer1 = scanner.nextInt();

        System.out.print("Introduce el segundo número: ");
        int numer2 = scanner.nextInt();

         
        System.out.println("Son iguales: "+(numer1 == numer2));
        System.out.println("El numero1 es mayor: "+(numer1 >= numer2));
        
        // 10. El mayor de 3
        scanner = new Scanner(System.in);
        
        System.out.println("Introduce el primer número: ");
        int numero1 = scanner.nextInt();
        
        System.out.println("Introduce el segundo número: ");
        int numero2 = scanner.nextInt();
        
        System.out.println("Introduce el tercer número: ");
        int numero3 = scanner.nextInt();
        
        int mayorej10 = Math.max(numero1, numero2);
        int mayorej101 = Math.max(mayorej10, numero3);
        
        System.out.println("Este es el mayor: "+(Math.max(mayorej10, mayorej101)));
        
        // 11.Mates
        scanner = new Scanner(System.in);
        System.out.println("NO SE PUEDE DIVIDIR POR 0");
        
        System.out.println("Introduce el primer número: ");
        int nu1 = scanner.nextInt();
        
        System.out.println("Introduce el segundo número: ");
        int nu2 = scanner.nextInt();

        int suma1 = nu1 + nu2;
        int resta1 = nu1 - nu2;
        int producto1 = nu1 * nu2;
        int division1 = nu1 / nu2;
        
        System.out.println(suma1);
        System.out.println(resta1);
        System.out.println(producto1);
        System.out.println(division1);
        
       // 12. Mayor
       scanner = new Scanner(System.in);
       
       System.out.println("Introduce el primer número: ");
       int numax1 = scanner.nextInt();
       
       System.out.println("Introduce el segundo número: ");
       int numax2 = scanner.nextInt();
       
       int maxnumber = Math.max(numax1, numax2);
       
       System.out.println("Este es el mayor: "+(maxnumber));
		 
       // 13. Positivo, Negativo
       scanner = new Scanner(System.in);
       
       System.out.print("Introduce el número: ");
       int numerpo1 = scanner.nextInt();

       System.out.println("ES POSITVO: "+(numerpo1 >= 0));
    }
        
        
    }