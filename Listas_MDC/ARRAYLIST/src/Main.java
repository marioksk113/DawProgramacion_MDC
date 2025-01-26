import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
       ArrayList<Producto> productos = new ArrayList<>();
       Scanner sc = new Scanner(System.in);
       int opcion;
       Producto p1 = null, p2 = null, p3 = null, p4 = null, p5 = null;
       
       do {
           System.out.println("\n=== MENÚ ===");
           System.out.println("1. Crear 5 productos");
           System.out.println("2. Crear ArrayList");
           System.out.println("3. Añadir productos al ArrayList");
           System.out.println("4. Mostrar productos con Iterator");
           System.out.println("5. Eliminar dos productos");
           System.out.println("6. Insertar producto en medio");
           System.out.println("7. Mostrar productos actualizados");
           System.out.println("8. Ordenar por nombre");
           System.out.println("9. Vaciar lista");
           System.out.println("10. Salir");
           System.out.print("Seleccione opción: ");
           opcion = sc.nextInt();
           
           switch(opcion) {
               case 1:
                   p1 = new Producto("Manzana", 10);
                   p2 = new Producto("Pera", 15);
                   p3 = new Producto("Naranja", 20);
                   p4 = new Producto("Plátano", 25);
                   p5 = new Producto("Kiwi", 30);
                   System.out.println("5 productos creados");
                   break;
                   
               case 2:
                   productos = new ArrayList<>();
                   System.out.println("ArrayList creado");
                   break;
                   
               case 3:
                   productos.add(p1);
                   productos.add(p2);
                   productos.add(p3);
                   productos.add(p4);
                   productos.add(p5);
                   System.out.println("Productos añadidos");
                   break;
                   
               case 4:
                   Iterator<Producto> it = productos.iterator();
                   while(it.hasNext()) {
                       System.out.println(it.next());
                   }
                   break;
                   
               case 5:
                   if(productos.size() >= 2) {
                       productos.remove(0);
                       productos.remove(0);
                       System.out.println("Dos productos eliminados");
                   }
                   break;
                   
               case 6:
                   int medio = productos.size() / 2;
                   productos.add(medio, new Producto("Uva", 40));
                   System.out.println("Producto insertado en medio");
                   break;
                   
               case 7:
                   Iterator<Producto> it2 = productos.iterator();
                   while(it2.hasNext()) {
                       System.out.println(it2.next());
                   }
                   break;
                   
               case 8:
                   Collections.sort(productos);
                   System.out.println("Lista ordenada por nombre");
                   break;
                   
               case 9:
                   productos.clear();
                   System.out.println("Lista vaciada");
                   break;
           }
       } while(opcion != 10);
       
       sc.close();
   }
}