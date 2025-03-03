import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionAlmacen gestor = new GestionAlmacen();
        
        System.out.println(gestor.cargarAlmacen());
        
        int opcion;
        
        do {
            System.out.println("\n=== GESTIÓN DEL ALMACÉN ===");
            System.out.println("1. Crear producto");
            System.out.println("2. Mostrar productos existentes");
            System.out.println("3. Eliminar producto por código");
            System.out.println("4. Guardar productos en el fichero");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                
                switch (opcion) {
                    case 1:
                        System.out.println("\n=== CREAR NUEVO PRODUCTO ===");
                        System.out.print("Código: ");
                        String codigo = scanner.nextLine();
                        
                        if (gestor.existeProducto(codigo)) {
                            System.out.println("Error: Ya existe un producto con ese código.");
                            break;
                        }
                        
                        System.out.print("Nombre: ");
                        String nombre = scanner.nextLine();
                        
                        System.out.print("Cantidad: ");
                        String cantidadStr = scanner.nextLine();
                        
                        System.out.print("Precio: ");
                        String precioStr = scanner.nextLine();
                        
                        System.out.println(gestor.crearProducto(codigo, nombre, cantidadStr, precioStr));
                        break;
                        
                    case 2:
                        System.out.println(gestor.mostrarProductos());
                        break;
                        
                    case 3:
                        System.out.println("\n=== ELIMINAR PRODUCTO ===");
                        System.out.print("Introduzca el código del producto a eliminar: ");
                        String codigoEliminar = scanner.nextLine();
                        
                        System.out.println(gestor.eliminarProducto(codigoEliminar));
                        break;
                        
                    case 4:
                        System.out.println(gestor.guardarProductos());
                        break;
                        
                    case 5:
                        System.out.println("¡Hasta pronto!");
                        break;
                        
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe introducir un número. Inténtelo de nuevo.");
                opcion = 0;
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                opcion = 0;
            }
            
        } while (opcion != 5);
        
        scanner.close();
    }
}