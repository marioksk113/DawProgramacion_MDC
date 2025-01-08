public class Principal {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Inventario inventario = new Inventario();
        int opcion;
        
        do {
            System.out.println("\n=== MENÚ TIENDA DE MASCOTAS ===");
            System.out.println("1. Mostrar lista de animales");
            System.out.println("2. Mostrar datos de un animal");
            System.out.println("3. Mostrar todos los animales");
            System.out.println("4. Insertar animal");
            System.out.println("5. Eliminar animal");
            System.out.println("6. Vaciar inventario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            
            switch (opcion) {
                case 1:
                    System.out.println(inventario.mostrarListaAnimales());
                    break;
                    
                case 2:
                    System.out.print("Ingrese el índice del animal: ");
                    int indice = scanner.nextInt();
                    System.out.println(inventario.mostrarAnimal(indice));
                    break;
                    
                case 3:
                    System.out.println(inventario.mostrarTodosAnimales());
                    break;
                    
                case 4:
                    System.out.println("\nTipo de animal a insertar:");
                    System.out.println("1. Perro");
                    System.out.println("2. Gato");
                    System.out.println("3. Loro");
                    System.out.println("4. Canario");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Estado: ");
                    String estado = scanner.nextLine();
                    System.out.print("Fecha de nacimiento: ");
                    String fechaNacimiento = scanner.nextLine();
                    
                    switch (tipo) {
                        case 1:
                            System.out.print("Raza: ");
                            String raza = scanner.nextLine();
                            System.out.print("Número de pulgas: ");
                            int pulgas = scanner.nextInt();
                            inventario.insertarAnimal(new Perro(nombre, edad, estado, fechaNacimiento, raza, pulgas));
                            break;
                            
                        case 2:
                            System.out.print("Color: ");
                            String colorGato = scanner.nextLine();
                            System.out.print("Pelo largo (Si/No): ");
                            String peloLargo = scanner.nextLine();
                            inventario.insertarAnimal(new Gato(nombre, edad, estado, fechaNacimiento, colorGato, peloLargo));
                            break;
                            
                        case 3:
                            System.out.print("Tipo de pico: ");
                            String picoLoro = scanner.nextLine();
                            System.out.print("¿Puede volar? (true/false): ");
                            boolean vuelaLoro = scanner.nextBoolean();
                            scanner.nextLine(); // Limpiar buffer
                            System.out.print("Origen: ");
                            String origen = scanner.nextLine();
                            System.out.print("Qué habla: ");
                            String hablaLoro = scanner.nextLine();
                            inventario.insertarAnimal(new Loro(nombre, edad, estado, fechaNacimiento, picoLoro, vuelaLoro, origen, hablaLoro));
                            break;
                            
                        case 4:
                            System.out.print("Tipo de pico: ");
                            String picoCanario = scanner.nextLine();
                            System.out.print("¿Puede volar? (true/false): ");
                            boolean vuelaCanario = scanner.nextBoolean();
                            scanner.nextLine(); // Limpiar buffer
                            System.out.print("Color: ");
                            String colorCanario = scanner.nextLine();
                            System.out.print("Canto: ");
                            String canta = scanner.nextLine();
                            inventario.insertarAnimal(new Canario(nombre, edad, estado, fechaNacimiento, picoCanario, vuelaCanario, colorCanario, canta));
                            break;
                    }
                    System.out.println("Animal insertado con éxito.");
                    break;
                    
                case 5:
                    System.out.print("Ingrese el índice del animal a eliminar: ");
                    int indiceEliminar = scanner.nextInt();
                    if (inventario.eliminarAnimal(indiceEliminar)) {
                        System.out.println("Animal eliminado con éxito.");
                    } else {
                        System.out.println("No se pudo eliminar el animal.");
                    }
                    break;
                    
                case 6:
                    inventario.vaciarInventario();
                    System.out.println("Inventario vaciado con éxito.");
                    break;
            }
        } while (opcion != 0);
        
        System.out.println("¡Gracias por usar el sistema!");
    }
}