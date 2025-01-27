import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList<Producto> listaProductos = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            // Mostrar menú
            System.out.println("\n=== MENÚ DE OPCIONES ===");
            System.out.println("1. Crear 5 productos");
            System.out.println("2. Crear LinkedList");
            System.out.println("3. Añadir productos al LinkedList");
            System.out.println("4. Visualizar LinkedList");
            System.out.println("5. Eliminar dos elementos");
            System.out.println("6. Insertar nuevo producto en medio");
            System.out.println("7. Visualizar LinkedList actualizado");
            System.out.println("8. Ordenar por nombre");
            System.out.println("9. Eliminar todos los valores");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch(opcion) {
                case 1:
                    System.out.println("Creando 5 productos...");
                    for(int i = 1; i <= 5; i++) {
                        System.out.print("Nombre del producto " + i + ": ");
                        String nombre = scanner.nextLine();
                        System.out.print("Cantidad del producto " + i + ": ");
                        int cantidad = scanner.nextInt();
                        scanner.nextLine();
                        new Producto(nombre, cantidad);
                    }
                    System.out.println("Productos creados exitosamente");
                    break;
                    
                case 2:
                    listaProductos = new LinkedList<>();
                    System.out.println("LinkedList creada exitosamente");
                    break;
                    
                case 3:
                    System.out.println("Añadiendo productos al LinkedList...");
                    for(int i = 1; i <= 5; i++) {
                        System.out.print("Nombre del producto " + i + ": ");
                        String nombre = scanner.nextLine();
                        System.out.print("Cantidad del producto " + i + ": ");
                        int cantidad = scanner.nextInt();
                        scanner.nextLine();
                        listaProductos.add(new Producto(nombre, cantidad));
                    }
                    System.out.println("Productos añadidos exitosamente");
                    break;
                    
                case 4:
                    if(listaProductos.isEmpty()) {
                        System.out.println("La lista está vacía");
                        break;
                    }
                    System.out.println("\nContenido de la lista:");
                    Iterator<Producto> it = listaProductos.iterator();
                    while(it.hasNext()) {
                        System.out.println(it.next());
                    }
                    break;
                    
                case 5:
                    if(listaProductos.size() < 2) {
                        System.out.println("No hay suficientes elementos para eliminar");
                        break;
                    }
                    listaProductos.remove(0);
                    listaProductos.remove(0);
                    System.out.println("Se eliminaron los dos primeros elementos");
                    break;
                    
                case 6:
                    System.out.print("Nombre del nuevo producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Cantidad del nuevo producto: ");
                    int cantidad = scanner.nextInt();
                    scanner.nextLine();
                    int medio = listaProductos.size() / 2;
                    listaProductos.add(medio, new Producto(nombre, cantidad));
                    System.out.println("Producto insertado en la posición " + medio);
                    break;
                    
                case 7:
                    if(listaProductos.isEmpty()) {
                        System.out.println("La lista está vacía");
                        break;
                    }
                    System.out.println("\nContenido actualizado de la lista:");
                    it = listaProductos.iterator();
                    while(it.hasNext()) {
                        System.out.println(it.next());
                    }
                    break;
                    
                case 8:
                    Collections.sort(listaProductos);
                    System.out.println("Lista ordenada por nombre");
                    break;
                    
                case 9:
                    listaProductos.clear();
                    System.out.println("Se han eliminado todos los elementos");
                    break;
                    
                case 10: 
                    System.out.println("Saliendo...");
                    break;
                    
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 10);
        
        scanner.close();
    }
}