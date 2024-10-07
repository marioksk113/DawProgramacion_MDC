package com.decroly.daw;

import java.util.Scanner;

public class Ejercico2_MDC {

	public static void main(String[] args) {
		
	//1
	Scanner scanner = new Scanner(System.in);
	
	System.out.println("¿Cuantos años tienes?");
	
	int edad = scanner.nextInt();
	
	if (edad >= 18) {
		
		System.out.println("Eres mayor de edad");
	}
		
	// 2
	scanner = new Scanner(System.in);
	
	System.out.println("¿Que edad tienes?");
	
	int edad1 = scanner.nextInt();
	
	if (edad1 >= 18) {
		
		System.out.println("Perfecto puedes pasar");
	}
	else {
	
		System.out.println("No puedes pasar");
	}
	
	// 3
	
	for(int cont=1; cont<=20; cont++) {
		
		System.out.print(cont + " ");
	}
		System.out.println("");
		

	
	// 4
	for (int cont = 2; cont <= 200; cont += 2) {
		
         if (cont % 2 == 0) {
        	 
        	 System.out.print(cont + " ");
         }
	}
			System.out.print("\n");
	// 5
	for (int cont = 1; cont <= 200; cont++) {
		
         if (cont % 2 == 0) {
        	 
        	 System.out.print(cont + " ");
         }
	}
	System.out.println("\n");
    // 6
	
	System.out.println("Escribe el número hasta donde quires contar");
	
	scanner = new Scanner(System.in);
	int contar = scanner.nextInt();
	
    for(int cont=1; cont<=contar; cont++) {
    		
    		System.out.print(cont + " ");
    	}
    		System.out.println("");
    		
    // 7
    		
    scanner = new Scanner(System.in);
    	        
        System.out.print("Indica tu nota entre 0 y 10: ");
    	        
    			  double nota = scanner.nextDouble();
    	        
    		      if (nota < 3) {
    			
    	System.out.println("Muy Deficiente");
    	            
    	        } else if (nota < 5) {
    	        	
    	System.out.println("Insuficiente");
    	            
    	        } else if (nota <= 6) {
    	        	
    	System.out.println("Bien");
    	            
    	        } else if (nota <= 8) {
    	        	
    	System.out.println("Notable");
    	            
    	        } else if (nota <= 10) {
    	        	
    	System.out.println("Sobresaliente");
    	            
    	        } else {
    	        	
    	System.out.println("Entre 1 y 10");
    	        }
	
     // 8
  
     scanner = new Scanner(System.in);
    
     System.out.print("Introduce un número positivo: ");
    
	     int num = scanner.nextInt();
	    
	     if (num < 0) {
	    	 
	 System.out.println("El número debe ser positivo.");
	 
	     } else {
	    	 
	        int factorial = 1;
	        
	        for (int i = 1; i <= num; i++) {factorial *= i;
	     }

     System.out.println("El factorial de " + num + " es: " + factorial);
     
	    }

	// 9

	scanner = new Scanner(System.in);


	System.out.print("Introduce la hora: ");

		int hora = scanner.nextInt();

	System.out.print("Introduce los minutos: ");

		int minuto = scanner.nextInt();

	System.out.print("Introduce los segundos: ");

		int segundo = scanner.nextInt();

		segundo++;

		if (segundo == 60) {
			segundo = 0;
			minuto++;
		}
		if (minuto == 60) {
			minuto = 0;
			hora++;
		}
		if (hora == 24) {
			hora = 0;
		}

	System.out.printf("La hora pasado un segundo es: %02d:%02d:%02d\n", hora, minuto, segundo);


			
	// 10

	scanner = new Scanner(System.in);

        int contador = 0;
        boolean hayNegativo = false;

        System.out.println("Introduce 10 números no nulos:");

		
        while (contador < 10) {
			scanner = new Scanner(System.in);
            System.out.println("Número " + (contador + 1) + ": ");
            int numero = scanner.nextInt();

            if (numero < 0) {
                hayNegativo = true;
            }

            contador++;
        }

        if (hayNegativo) {
            System.out.println("Hay números negativos.");
        } else {
            System.out.println("No hay números negativos.");
        }
	// 11

	scanner = new Scanner(System.in);

		int contador11 = 0;
		int positivos = 0;
		int negativos = 0;

	System.out.println("Introduce 10 números no nulos:");

		while (contador11 < 10) {
			System.out.println("Número " + (contador11 + 1) + ": ");
			int numero = scanner.nextInt();

			if (numero > 0) {
				positivos++;

			} else if (numero < 0) {
				negativos++;
			}

			contador11++; 
		}

	System.out.println("Números positivos: " + positivos);
	System.out.println("Números negativos: " + negativos);

	// 12	

	scanner = new Scanner(System.in);

        int numero;
        int positivos12 = 0;
        int negativos12 = 0;
        boolean hayNegativo12 = false;

    System.out.println("Introduce una secuencia de números (introduce 0 para finalizar):");

        
        while (true) {
            
			numero = scanner.nextInt();

            if (numero == 0) {
                break;
            }

            if (numero > 0) {
                positivos12++;

            } else {
                negativos12++;
                hayNegativo12 = true;
            }
        }

        if (hayNegativo12) {

            System.out.println("Se ha introducido al menos un número negativo.");
        } else {

            System.out.println("No se ha introducido ningún número negativo.");
        }

    System.out.println("Números positivos: " + positivos12);
    System.out.println("Números negativos: " + negativos12);

	// 13

		int suma = 0;
        int producto = 1;

      
        for (int i = 1; i <= 10; i++) {
            suma += i;       
            producto *= i;    
        }

        System.out.println("La suma de los 10 primeros números naturales es: " + suma);
        System.out.println("El producto de los 10 primeros números naturales es: " + producto);
    
	// 14

	scanner = new Scanner(System.in);


    System.out.println("Introduce el nombre del trabajador: ");
       
		String nombre = scanner.nextLine();


    System.out.println("Introduce el número de horas trabajadas: ");
        
		double horasTrabajadas = scanner.nextDouble();

    System.out.println("Introduce el pago por hora: ");
        
		double tarifaHora = scanner.nextDouble();

		double salarioBruto;

        if (horasTrabajadas <= 35) {

            salarioBruto = horasTrabajadas * tarifaHora;
			
        } else {
        
            salarioBruto = 35 * tarifaHora + (horasTrabajadas - 35) * tarifaHora * 1.5;
        }

        double impuestos = 0;
        if (salarioBruto > 900) {

            impuestos += (salarioBruto - 900) * 0.45;
            impuestos += 400 * 0.25;

        } else if (salarioBruto > 500) {

            impuestos += (salarioBruto - 500) * 0.25;
        }

        double salarioNeto = salarioBruto - impuestos;

	System.out.println("Nombre del trabajador: " + nombre);
	System.out.println("Salario bruto: " + salarioBruto + " euros");
	System.out.println("Impuestos: " + impuestos + " euros");
	System.out.println("Salario neto: " + salarioNeto + " euros");














































	}//main

}//clase

