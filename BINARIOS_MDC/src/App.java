import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        GestionAlmacen almacen = new GestionAlmacen();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        
        do {
            System.out.println("\n--- SISTEMA DE GESTIÓN DE ALMACÉN ---");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Eliminar Producto");
            System.out.println("3. Buscar Producto");
            System.out.println("4. Actualizar Cantidad");
            System.out.println("5. Mostrar Todos los Productos");
            System.out.println("6. Calcular Valor Total del Inventario");
            System.out.println("7. Guardar Cambios");
            System.out.println("8. Salir");
            System.out.print("Elija una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombre = scanner.nextLine();
                    
                    System.out.print("Ingrese el precio: ");
                    double precio = scanner.nextDouble();
                    
                    System.out.print("Ingrese la cantidad: ");
                    int cantidad = scanner.nextInt();
                    
                    Producto nuevoProducto = new Producto(nombre, precio, cantidad);
                    almacen.agregarProducto(nuevoProducto);
                    System.out.println("Producto agregado correctamente.");
                    break;
                
                case 2:
                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    
                    boolean eliminado = almacen.eliminarProducto(nombreEliminar);
                    if (eliminado) {
                        System.out.println("Producto eliminado correctamente.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                
                case 3:
                    System.out.print("Ingrese el nombre del producto a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    
                    Producto productoBuscado = almacen.buscarProducto(nombreBuscar);
                    if (productoBuscado != null) {
                        System.out.println("Producto encontrado:");
                        System.out.println("Nombre: " + productoBuscado.getNombre());
                        System.out.println("Precio: " + productoBuscado.getPrecio() + " $");
                        System.out.println("Cantidad: " + productoBuscado.getCantidad());
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                
                case 4:
                    System.out.print("Ingrese el nombre del producto: ");
                    String nombreActualizar = scanner.nextLine();
                    
                    System.out.print("Ingrese la nueva cantidad: ");
                    int nuevaCantidad = scanner.nextInt();
                    
                    boolean actualizado = almacen.actualizarCantidad(nombreActualizar, nuevaCantidad);
                    if (actualizado) {
                        System.out.println("Cantidad actualizada correctamente.");
                    } else {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                
                case 5:
                    System.out.println("--- LISTA DE PRODUCTOS ---");
                    almacen.mostrarProductos();
                    break;
                
                case 6:
                    double valorTotal = almacen.calcularValorInventario();
                    System.out.printf("Valor total del inventario: $%.2f%n", valorTotal);
                    break;
                
                case 7:
                    almacen.guardarDatos();
                    break;
                
                case 8:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    System.exit(0);
                
                default:
                    System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }
        } while (opcion != 8);
    }
}