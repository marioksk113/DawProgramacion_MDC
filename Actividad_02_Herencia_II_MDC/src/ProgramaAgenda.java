import java.util.Scanner;

class ProgramaAgenda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcion;
        String nombre, telefono;
        
        do {
            // Mostrar menú
            System.out.println("\n=== AGENDA DE CONTACTOS ===");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Eliminar contacto");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Comprobar si existe contacto");
            System.out.println("5. Listar todos los contactos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer
            
            switch(opcion) {
                case 1:
                    System.out.print("Introduce el nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Introduce el teléfono: ");
                    telefono = sc.nextLine();
                    
                    Contacto nuevoContacto = new Contacto(nombre, telefono);
                    if(agenda.añadirContacto(nuevoContacto)) {
                        System.out.println("Contacto añadido correctamente");
                    } else {
                        System.out.println("No se pudo añadir el contacto. Agenda llena o contacto existente");
                    }
                    break;
                    
                case 2:
                    System.out.print("Introduce el nombre del contacto a eliminar: ");
                    nombre = sc.nextLine();
                    if(agenda.eliminarContacto(nombre)) {
                        System.out.println("Contacto eliminado correctamente");
                    } else {
                        System.out.println("No se pudo eliminar el contacto");
                    }
                    break;
                    
                case 3:
                    System.out.print("Introduce el nombre del contacto a buscar: ");
                    nombre = sc.nextLine();
                    int posicion = agenda.buscaContacto(nombre);
                    if(posicion >= 0) {
                        System.out.println("El contacto está en la posición: " + posicion);
                    } else {
                        System.out.println("Contacto no encontrado");
                    }
                    break;
                    
                case 4:
                    System.out.print("Introduce el nombre del contacto a comprobar: ");
                    nombre = sc.nextLine();
                    if(agenda.existeContacto(nombre)) {
                        System.out.println("El contacto existe en la agenda");
                    } else {
                        System.out.println("El contacto no existe en la agenda");
                    }
                    break;
                    
                case 5:
                    System.out.println("\nLISTA DE CONTACTOS:");
                    System.out.println(agenda.listarContactos());
                    break;
                    
                case 6:
                    System.out.println("¡Hasta luego!");
                    break;
                    
                default:
                    System.out.println("Opción no válida");
                    break;
            }
            
        } while(opcion != 6);

    }
}