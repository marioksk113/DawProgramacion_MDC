public class Principal {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int opcion;
        String resultado;
        
        do {
            System.out.println("\n=== MENÚ TIENDA DE MASCOTAS ===");
            System.out.println("1. Mostrar lista de animales");
            System.out.println("2. Mostrar datos de un animal específico");
            System.out.println("3. Mostrar datos de todos los animales");
            System.out.println("4. Insertar nuevo animal");
            System.out.println("5. Eliminar animal");
            System.out.println("6. Vaciar inventario");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            
            switch(opcion) {
                case 1:
                    System.out.println("\nLista de animales:");
                    System.out.println(inventario.mostrarListaAnimales());
                    break;
                    
                case 2:
                    System.out.print("Ingrese el índice del animal: ");
                    int indice = scanner.nextInt();
                    System.out.println(inventario.mostrarAnimal(indice));
                    break;
                    
                case 3:
                    System.out.println("\nDatos de todos los animales:");
                    System.out.println(inventario.mostrarTodosAnimales());
                    break;
                    
                case 4:
                    System.out.println("\nTipo de animal a insertar:");
                    System.out.println("1. Perro");
                    System.out.println("2. Gato");
                    System.out.println("3. Loro");
                    System.out.println("4. Canario");
                    System.out.print("Seleccione tipo: ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    System.out.print("Fecha Nacimiento (YYYY-MM-DD): ");
                    String fechaNacimiento = scanner.nextLine();
                    
                    Mascotas nuevoAnimal = null;
                    
                    switch(tipo) {
                        case 1:
                            System.out.print("Raza: ");
                            String raza = scanner.nextLine();
                            boolean pulgas = false;
                            String respuestaPulgas;
                            do {
                                System.out.print("¿Tiene pulgas? (true/false): ");
                                respuestaPulgas = scanner.nextLine().toLowerCase();
                                if(respuestaPulgas.equals("true") || respuestaPulgas.equals("false")) {
                                    pulgas = Boolean.parseBoolean(respuestaPulgas);
                                } else {
                                    System.out.println("Por favor, introduce solo 'true' o 'false'");
                                }
                            } while(!respuestaPulgas.equals("true") && !respuestaPulgas.equals("false"));
                            
                            nuevoAnimal = new Perro(nombre, edad, fechaNacimiento, raza, pulgas);
                            break;
                            
                        case 2:
                            System.out.print("Color: ");
                            String colorGato = scanner.nextLine();
                            boolean peloLargo = false;
                            String respuestaPelo;
                            do {
                                System.out.print("¿Tiene pelo largo? (true/false): ");
                                respuestaPelo = scanner.nextLine().toLowerCase();
                                if(respuestaPelo.equals("true") || respuestaPelo.equals("false")) {
                                    peloLargo = Boolean.parseBoolean(respuestaPelo);
                                } else {
                                    System.out.println("Por favor, introduce solo 'true' o 'false'");
                                }
                            } while(!respuestaPelo.equals("true") && !respuestaPelo.equals("false"));
                            
                            nuevoAnimal = new Gato(nombre, edad, fechaNacimiento, colorGato, peloLargo);
                            break;
                            
                        case 3:
                            System.out.print("Origen: ");
                            String origen = scanner.nextLine();
                            System.out.print("Frase que habla: ");
                            String habla = scanner.nextLine();
                            nuevoAnimal = new Loro(nombre, edad, fechaNacimiento, origen, habla);
                            break;
                            
                        case 4:
                            System.out.print("Color: ");
                            String colorCanario = scanner.nextLine();
                            boolean canta = false;
                            String respuestaCanta;
                            do {
                                System.out.print("¿Canta? (true/false): ");
                                respuestaCanta = scanner.nextLine().toLowerCase();
                                if(respuestaCanta.equals("true") || respuestaCanta.equals("false")) {
                                    canta = Boolean.parseBoolean(respuestaCanta);
                                } else {
                                    System.out.println("Por favor, introduce solo 'true' o 'false'");
                                }
                            } while(!respuestaCanta.equals("true") && !respuestaCanta.equals("false"));
                            
                            nuevoAnimal = new Canario(nombre, edad, fechaNacimiento, colorCanario, canta);
                            break;
                    }
                    
                    if(nuevoAnimal != null) {
                        System.out.println(inventario.insertarAnimal(nuevoAnimal));
                    }
                    break;
                    
                case 5:
                    System.out.print("Ingrese el índice del animal a eliminar: ");
                    int indiceEliminar = scanner.nextInt();
                    System.out.println(inventario.eliminarAnimal(indiceEliminar));
                    break;
                    
                case 6:
                    System.out.println(inventario.vaciarInventario());
                    break;
                    
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                    
                default:
                    System.out.println("Opción no válida");
                    break;
            }
            
        } while(opcion != 0);
        
        scanner.close();
    }
}