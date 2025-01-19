import java.util.Scanner;

class ProgramaAgenda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Agenda agenda = new Agenda();
        int opcion, tipo;
        String nombre, telefono, extra;
        
        do {
            System.out.println("\n=== AGENDA DE CONTACTOS ===");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Eliminar contacto");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Comprobar si existe contacto");
            System.out.println("5. Listar todos los contactos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch(opcion) {
                case 1:
                    System.out.println("Tipo de contacto:");
                    System.out.println("1. Persona");
                    System.out.println("2. Empresa");
                    tipo = sc.nextInt();
                    sc.nextLine();
                    
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Teléfono: ");
                    telefono = sc.nextLine();
                    
                    if(tipo == 1) {
                        System.out.print("Cumpleaños (dd/mm/yyyy): ");
                        extra = sc.nextLine();
                        if(agenda.añadirContacto(new ContactoPersona(nombre, telefono, extra))) {
                            System.out.println("Persona añadida correctamente");
                        }
                    } else if(tipo == 2) {
                        System.out.print("Página web: ");
                        extra = sc.nextLine();
                        if(agenda.añadirContacto(new ContactoEmpresa(nombre, telefono, extra))) {
                            System.out.println("Empresa añadida correctamente");
                        }
                    }
                    break;
                    
                case 2:
                    System.out.print("Nombre del contacto a eliminar: ");
                    nombre = sc.nextLine();
                    if(agenda.eliminarContacto(nombre)) {
                        System.out.println("Contacto eliminado correctamente");
                    } else {
                        System.out.println("No se pudo eliminar el contacto");
                    }
                    break;
                    
                case 3:
                    System.out.print("Nombre del contacto a buscar: ");
                    nombre = sc.nextLine();
                    int posicion = agenda.buscaContacto(nombre);
                    if(posicion >= 0) {
                        System.out.println("El contacto está en la posición: " + posicion);
                    } else {
                        System.out.println("Contacto no encontrado");
                    }
                    break;
                    
                case 4:
                    System.out.print("Nombre del contacto a comprobar: ");
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
        
        sc.close();
    }
}