package com.decroly.daw;

<<<<<<< HEAD
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
	
	} 
=======
public class Ejercico2_MDC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
>>>>>>> 231769317ad45c5dd1342a8653a8f1e38f44ff2a

}
