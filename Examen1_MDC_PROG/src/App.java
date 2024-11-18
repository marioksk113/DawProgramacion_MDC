import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
    Scanner scanner = new Scanner(System.in);

        System.out.println("¿Qué tamaño quieres que tenga el array?");
            int arraySize = scanner.nextInt();
// Le pedimos el valor para definir el tamaño del array
            int[] nummdc = new int[arraySize];

            char option;

        do {
            System.out.println("Menú:");
            System.out.println("a. Mostrar valores");
            System.out.println("b. Introducir/Modificar valor");
            System.out.println("c. Que valor quieres borrar");
            System.out.println("d. Media");
            System.out.println("e. Suma");
            System.out.println("f. Maximo");
            System.out.println("g. Minimo");
            System.out.println("h. Salir");
            System.out.print("Elige una opción: ");
            option = scanner.next().charAt(0);
//Creamos el menu con las opciones
                switch (option) {
                    case 'a':
                        mostrarValores(nummdc);
                        break;
                    case 'b':
                        System.out.print("Introduce el valor (entero): ");
                        int valor = scanner.nextInt();
                        System.out.print("Introduce la posición (0- " + nummdc.length + "): ");
                        int posicion = scanner.nextInt();

                        if (posicion >= 0 && posicion < nummdc.length) {
                            nummdc[posicion] = valor;
                            System.out.println("Valor introducido correctamente.");
                        } else {
                            System.out.println("Posición inválida. Debe estar entre 0 y 9.");
                        }
                        break;

                    case 'c':
                        
                        System.out.print("Introduce la posición que quieres borrar (0- " + nummdc.length + "): ");
                        int posicionbor = scanner.nextInt();

                        if (posicionbor >= 0 && posicionbor < nummdc.length) {
                            int valorbor = 0;
                            nummdc[posicionbor] = valorbor;
                            System.out.println("Valor borrado correctamente.");
                        } else {
                            System.out.println("Posición inválida. Debe estar entre (0- " + nummdc.length + "): ");
                        }
                        break;

                    case 'd':
                        
                        double media = 0;
                        double sumamedia = 0;

                        for (int i = 0; i < nummdc.length; i++) {
                            
                            sumamedia += nummdc[i]; }
                
                            media = sumamedia / nummdc.length;
                    
                    
                        System.out.println("La media es: " + media);
                        break;

                    case 'e':
                        int suma = 0;
                    
                        for (int i = 0; i < nummdc.length; i++) {
                
                            suma += nummdc[i];
                        } 

                        System.out.println(suma);
                        break;

                    case 'f':

                        double max = nummdc[0];


                        for (int i = 1; i < nummdc.length; i++) {
                            if (nummdc[i] > max) {
                                max = nummdc[i];
                            }
                        }

                        System.out.println("El número máximo es: " + max);
                        break;
                    
                    case 'g':
                        double min = nummdc[1];
                        for (int i = 1; i < nummdc.length; i++) {

                            if (nummdc[i] < min) {
                                min = nummdc[i];
                                
                            }
                        }
                        System.out.println("El número mínimo es: " + min); 
                        break;
                    
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                }

                    } while (option != 'h');
                

                }


    public static void mostrarValores(int[] nummdc) {
        System.out.println("Valores en el array:");
        for (int i = 0; i < nummdc.length; i++) {
            System.out.println("Posición " + i + ": " + nummdc[i]);

        }


    }
}
