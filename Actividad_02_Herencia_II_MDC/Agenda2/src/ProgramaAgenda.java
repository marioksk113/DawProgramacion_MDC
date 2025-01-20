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
            System.out.println("5. Listar contactos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = sc.nextInt();
            sc.nextLine();
            
            switch(opcion) {
                case 1:
                    System.out.println("\n=== AÑADIR CONTACTO ===");
                    System.out.println("1. Añadir Persona");
                    System.out.println("2. Añadir Empresa");
                    System.out.print("Seleccione tipo: ");
                    tipo = sc.nextInt();
                    sc.nextLine();
                    
                    if (tipo != 1 && tipo != 2) {
                        System.out.println("Tipo no válido");
                        break;
                    }
                    
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Teléfono: ");
                    telefono = sc.nextLine();
                    
                    if(tipo == 1) {
                        System.out.print("Cumpleaños (dd/mm/yyyy): ");
                        extra = sc.nextLine();
                        if(agenda.añadirContacto(new ContactoPersona(nombre, telefono, extra))) {
                            System.out.println("Persona añadida correctamente");
                        } else {
                            System.out.println("No se pudo añadir. Agenda llena o nombre duplicado");
                        }
                    } else {
                        System.out.print("Página web: ");
                        extra = sc.nextLine();
                        if(agenda.añadirContacto(new ContactoEmpresa(nombre, telefono, extra))) {
                            System.out.println("Empresa añadida correctamente");
                        } else {
                            System.out.println("No se pudo añadir. Agenda llena o nombre duplicado");
                        }
                    }
                    break;
                    
                case 2:
                    System.out.println("\n=== ELIMINAR CONTACTO ===");
                    System.out.println("1. Eliminar Persona");
                    System.out.println("2. Eliminar Empresa");
                    System.out.print("Seleccione tipo: ");
                    tipo = sc.nextInt();
                    sc.nextLine();
                    
                    if (tipo != 1 && tipo != 2) {
                        System.out.println("Tipo no válido");
                        break;
                    }
                    
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    
                    int pos = agenda.buscaContacto(nombre);
                    if (pos >= 0) {
                        Contacto c = agenda.getContacto(pos);
                        boolean tipoCorrespondiente = 
                            (tipo == 1 && c instanceof ContactoPersona) ||
                            (tipo == 2 && c instanceof ContactoEmpresa);
                            
                        if (tipoCorrespondiente) {
                            agenda.eliminarContacto(nombre);
                            System.out.println("Contacto eliminado correctamente");
                        } else {
                            System.out.println("El contacto existe pero no es del tipo seleccionado");
                        }
                    } else {
                        System.out.println("Contacto no encontrado");
                    }
                    break;
                    
                case 3:
                    System.out.println("\n=== BUSCAR CONTACTO ===");
                    System.out.println("1. Buscar Persona");
                    System.out.println("2. Buscar Empresa");
                    System.out.print("Seleccione tipo: ");
                    tipo = sc.nextInt();
                    sc.nextLine();
                    
                    if (tipo != 1 && tipo != 2) {
                        System.out.println("Tipo no válido");
                        break;
                    }
                    
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    
                    pos = agenda.buscaContacto(nombre);
                    if (pos >= 0) {
                        Contacto c = agenda.getContacto(pos);
                        boolean tipoCorrespondiente = 
                            (tipo == 1 && c instanceof ContactoPersona) ||
                            (tipo == 2 && c instanceof ContactoEmpresa);
                            
                        if (tipoCorrespondiente) {
                            System.out.println("Contacto encontrado en la posición: " + pos);
                            System.out.println(c.toString());
                        } else {
                            System.out.println("El contacto existe pero no es del tipo seleccionado");
                        }
                    } else {
                        System.out.println("Contacto no encontrado");
                    }
                    break;
                    
                case 4:
                    System.out.println("\n=== COMPROBAR EXISTENCIA ===");
                    System.out.println("1. Comprobar Persona");
                    System.out.println("2. Comprobar Empresa");
                    System.out.print("Seleccione tipo: ");
                    tipo = sc.nextInt();
                    sc.nextLine();
                    
                    if (tipo != 1 && tipo != 2) {
                        System.out.println("Tipo no válido");
                        break;
                    }
                    
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    
                    pos = agenda.buscaContacto(nombre);
                    if (pos >= 0) {
                        Contacto c = agenda.getContacto(pos);
                        boolean tipoCorrespondiente = 
                            (tipo == 1 && c instanceof ContactoPersona) ||
                            (tipo == 2 && c instanceof ContactoEmpresa);
                            
                        if (tipoCorrespondiente) {
                            System.out.println("El contacto existe en la agenda");
                        } else {
                            System.out.println("Existe un contacto con ese nombre pero no es del tipo seleccionado");
                        }
                    } else {
                        System.out.println("El contacto no existe en la agenda");
                    }
                    break;
                    
                case 5:
                    System.out.println("\n=== LISTAR CONTACTOS ===");
                    System.out.println("1. Listar Personas");
                    System.out.println("2. Listar Empresas");
                    System.out.println("3. Listar Todos");
                    System.out.print("Seleccione tipo: ");
                    tipo = sc.nextInt();
                    sc.nextLine();
                    
                    if (tipo < 1 || tipo > 3) {
                        System.out.println("Tipo no válido");
                        break;
                    }
                    
                    System.out.println("\nLISTA DE CONTACTOS:");
                    System.out.println(agenda.listarContactos(tipo));
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