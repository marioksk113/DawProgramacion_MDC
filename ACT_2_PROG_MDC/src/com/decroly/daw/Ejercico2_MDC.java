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

	System.out.println("Numero 1: ");

		int n1 = scanner.nextInt();
	
	System.out.println("Numero 2: ");

		int n2 = scanner.nextInt();
	
	System.out.println("Numero 3: ");

		int n3 = scanner.nextInt();
	
	System.out.println("Numero 4: ");

		int n4 = scanner.nextInt();

	System.out.println("Numero 5: ");

		int n5 = scanner.nextInt();
	
	System.out.println("Numero 6: ");

		int n6 = scanner.nextInt();
	
	System.out.println("Numero 7: ");

		int n7 = scanner.nextInt();
	
	System.out.println("Numero 8: ");

		int n8 = scanner.nextInt();

	System.out.println("Numero 9: ");

		int n9 = scanner.nextInt();
	
	System.out.println("Numero 10: ");

		int n10 = scanner.nextInt();

		if (n1 < 0 || n2 < 0 || n3 < 0 || n4 < 0 || n5 < 0 || 
			n6 < 0 || n7 < 0 || n8 < 0 || n9 < 0 || n10 < 0) {
			
			System.out.print("Hay numeros negativos");
		} else {
			System.out.println("No hay numeros negativos");
		}

	// 11

	scanner = new Scanner(System.in);

	System.out.println("Numero 1: ");

		int nm1 = scanner.nextInt();
	
	System.out.println("Numero 2: ");

		int nm2 = scanner.nextInt();
	
	System.out.println("Numero 3: ");

		int nm3 = scanner.nextInt();
	
	System.out.println("Numero 4: ");

		int nm4 = scanner.nextInt();

	System.out.println("Numero 5: ");

		int nm5 = scanner.nextInt();
	
	System.out.println("Numero 6: ");

		int nm6 = scanner.nextInt();
	
	System.out.println("Numero 7: ");

		int nm7 = scanner.nextInt();
	
	System.out.println("Numero 8: ");

		int nm8 = scanner.nextInt();

	System.out.println("Numero 9: ");

		int nm9 = scanner.nextInt();
	
	System.out.println("Numero 10: ");

		int nm10 = scanner.nextInt();

		
		int positivos = 0;
		int negativos = 0;
		
		if (nm1 < 0) {

			positivos++;

		} else {
			negativos++;
		}

		if (nm2 < 0) {

			positivos++;

		} else {
			negativos++;
		}

		if (nm3 < 0) {

			positivos++;

		} else {
			negativos++;
		}

		if (nm4 < 0) {

			positivos++;

		} else {
			negativos++;
		}

		if (nm5 < 0) {

			positivos++;

		} else {
			negativos++;
		}

		if (nm6 < 0) {

			positivos++;

		} else {
			negativos++;
		}

		if (nm7 < 0) {

			positivos++;

		} else {
			negativos++;
		}

		if (nm8 < 0) {

			positivos++;

		} else {
			negativos++;
		}

		if (nm9 < 0) {

			positivos++;

		} else {
			negativos++;
		}

		if (nm10 < 0) {

			positivos++;

		} else {
			negativos++;
		}
	
	System.out.println("Cantidad de numeros positivos: "+positivos);
	System.out.println("Cantidad de numeros negativos: "+negativos);

	














































	}//main

}//clase

