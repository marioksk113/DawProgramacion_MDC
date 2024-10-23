import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        

        // 1    
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Introduce una cadena de texto:");
        
            String cadena = scanner.nextLine();
            
            String[] palabras = cadena.split(" ");
            
            for (String palabra : palabras) {
            System.out.println(palabra);
        }

        // 2
        scanner = new Scanner(System.in);
        
        System.out.println("Introduce una cadena de texto 1:");
            String cadena1 = scanner.nextLine();
            
        System.out.println("Introduce una cadena de texto 2:");
            
            String cadena2 = scanner.nextLine();
            
            if (cadena1.equalsIgnoreCase(cadena2)) {
                System.out.println("Las cadenas son iguales.");
            
            } else {
                System.out.println("Las cadenas son diferentes.");
            }

        // 3 
        scanner = new Scanner(System.in);
        System.out.println("Introduce nombre:");
            
            String nombre = scanner.nextLine();
        
        System.out.println("Introduce apellido:");
            
            String apellido1 = scanner.nextLine();
        
        System.out.println("Introduce apellido 2:");
            
            String apellido2 = scanner.nextLine();
            String codigoUsuario = (nombre.substring(0, 3) + apellido1.substring(0, 3) + apellido2.substring(0, 3)).toUpperCase();
        
        System.out.println("El código de usuario es: " + codigoUsuario);

        // 4
        scanner = new Scanner(System.in);
        
        System.out.println("Introduce una frase:");
        
            String frase = scanner.nextLine().toLowerCase();
            int contA = 0, contE = 0, contI = 0, contO = 0, contU = 0;
            for (char c : frase.toCharArray()) {
                switch (c) {
                    case 'a':
                        contA++;
                        break;
                    case 'e':
                        contE++;
                        break;
                    case 'i':
                        contI++;
                        break;
                    case 'o':
                        contO++;
                        break;
                    case 'u':
                        contU++;
                        break;
                    default:
                        break;
                }
            }

        System.out.println("Nº de A's: " + contA);
        System.out.println("Nº de E's: " + contE);
        System.out.println("Nº de I's: " + contI);
        System.out.println("Nº de O's: " + contO);
        System.out.println("Nº de U's: " + contU);

        // 5
        scanner = new Scanner(System.in);
        
        System.out.println("Introduce una frase: ");
            String frase5 = scanner.nextLine();
            String fraseModificada = frase5.replace(" ", "").toLowerCase();
            if (esPalindromo(fraseModificada)) {
                System.out.println("La frase es un palíndromo.");
            } else {
                System.out.println("La frase no es un palíndromo.");
            }
        }

    public static boolean esPalindromo(String texto) {
        int longitud = texto.length();
        for (int i = 0; i < longitud / 2; i++) {
            if (texto.charAt(i) != texto.charAt(longitud - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
