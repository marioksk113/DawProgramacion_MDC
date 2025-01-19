class Agenda {
    private Contacto[] contactos;
    private int numContactos;
    private final int MAX_CONTACTOS = 100;
    
    // Constructor
    public Agenda() {
        contactos = new Contacto[MAX_CONTACTOS];
        numContactos = 0;
    }
    
    // Añadir contacto
    public boolean añadirContacto(Contacto c) {
        if(numContactos >= MAX_CONTACTOS || existeContacto(c.getNombre())) {
            return false;
        }
        
        contactos[numContactos] = c;
        numContactos++;
        return true;
    }
    
    // Eliminar contacto
    public boolean eliminarContacto(String nombre) {
        int pos = buscaContacto(nombre);
        if(pos < 0) {
            return false;
        }
        
        // Desplazar elementos
        for(int i = pos; i < numContactos - 1; i++) {
            contactos[i] = contactos[i + 1];
        }
        
        contactos[numContactos - 1] = null;
        numContactos--;
        return true;
    }
    
    // Verificar si existe contacto
    public boolean existeContacto(String nombre) {
        return buscaContacto(nombre) >= 0;
    }
    
    // Listar contactos
    public String listarContactos() {
        if(numContactos == 0) {
            return "No hay contactos en la agenda";
        }
        
        StringBuilder lista = new StringBuilder();
        for(int i = 0; i < numContactos; i++) {
            lista.append(contactos[i].toString()).append("\n");
        }
        return lista.toString();
    }
    
    // Buscar contacto
    public int buscaContacto(String nombre) {
        for(int i = 0; i < numContactos; i++) {
            if(contactos[i].getNombre().equals(nombre)) {
                return i;
            }
        }
        return -1;
    }
    
    // Método  para obtener el número de contactos
    public int getNumContactos() {
        return numContactos;
    }
}