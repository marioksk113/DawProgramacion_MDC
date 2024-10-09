package com.decroly.daw;

import java.util.Scanner;

public class Ejercico3_MDC {

	public static void main(String[] args) {

	// 1	

	Scanner sc = new Scanner(System.in);

		System.out.print("Introduce una cantidad de euros (múltiplo de 5): ");
			int cantidad = sc.nextInt();

        if (cantidad % 5 != 0) {
            System.out.println("La cantidad debe ser un múltiplo de 5.");
            return;
        }

			int billete500 = cantidad / 500;
			cantidad %= 500;

			int billete200 = cantidad / 200;
			cantidad %= 200;

			int billete100 = cantidad / 100;
			cantidad %= 100;

			int billete50 = cantidad / 50;
			cantidad %= 50;

			int billete20 = cantidad / 20;
			cantidad %= 20;

			int billete10 = cantidad / 10;
			cantidad %= 10;

			int billete5 = cantidad / 5;

        System.out.println("Billetes necesarios:");

        if (billete500 > 0) System.out.println(billete500 + " billete de 500 ");
        if (billete200 > 0) System.out.println(billete200 + " billete de 200 ");
        if (billete100 > 0) System.out.println(billete100 + " billete de 100 ");
        if (billete50 > 0) System.out.println(billete50 + " billete de 50 ");
        if (billete20 > 0) System.out.println(billete20 + " billete de 20 ");
        if (billete10 > 0) System.out.println(billete10 + " billete de 10 ");
        if (billete5 > 0) System.out.println(billete5 + " billete de 5 ");


	// 2

			int opcion;
       		double num1, num2;

        do {
            
            System.out.println("Menú de opciones:");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            
            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Introduce el primer número: ");
                num1 = sc.nextDouble();
                System.out.print("Introduce el segundo número: ");
                num2 = sc.nextDouble();

                switch (opcion) {
                    case 1:
                        
                        System.out.println("Resultado: " + (num1 + num2));
                        break;
                    case 2:
                        
                        System.out.println("Resultado: " + (num1 - num2));
                        break;
                    case 3:
                        
                        System.out.println("Resultado: " + (num1 * num2));
                        break;
                    case 4:
                        
                        if (num2 != 0) {
                            System.out.println("Resultado: " + (num1 / num2));

                        } else {
                            System.out.println("Error: No se puede dividir entre 0.");
                        }
                        break;

                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } else if (opcion != 5) {
                System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        System.out.println("Has salido del programa.");


















	}

}
