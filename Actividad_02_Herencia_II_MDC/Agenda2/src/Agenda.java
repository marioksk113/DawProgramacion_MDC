class Agenda {
    private Contacto[] contactos;
    private int numContactos;
    private final int MAX_CONTACTOS = 100;
    
    public Agenda() {
        contactos = new Contacto[MAX_CONTACTOS];
        numContactos = 0;
    }
    
    public boolean añadirContacto(Contacto c) {
        if(numContactos >= MAX_CONTACTOS || existeContacto(c.getNombre())) {
            return false;
        }
        contactos[numContactos] = c;
        numContactos++;
        return true;
    }
    
    public boolean eliminarContacto(String nombre) {
        int pos = buscaContacto(nombre);
        if(pos < 0) {
            return false;
        }
        
        for(int i = pos; i < numContactos - 1; i++) {
            contactos[i] = contactos[i + 1];
        }
        
        contactos[numContactos - 1] = null;
        numContactos--;
        return true;
    }
    
    public boolean existeContacto(String nombre) {
        return buscaContacto(nombre) >= 0;
    }
    
    public String listarContactos() {
        return listarContactos(3);
    }
    
    public String listarContactos(int tipo) {
        if(numContactos == 0) {
            return "No hay contactos en la agenda";
        }
        
        StringBuilder lista = new StringBuilder();
        for(int i = 0; i < numContactos; i++) {
            boolean incluir = false;
            
            switch(tipo) {
                case 1: // Solo personas
                    incluir = contactos[i] instanceof ContactoPersona;
                    break;
                case 2: // Solo empresas
                    incluir = contactos[i] instanceof ContactoEmpresa;
                    break;
                case 3: // Todos
                    incluir = true;
                    break;
            }
            
            if(incluir) {
                lista.append(contactos[i].toString()).append("\n");
            }
        }
        
        if(lista.length() == 0) {
            return "No hay contactos del tipo seleccionado";
        }
        
        return lista.toString();
    }
    
    public int buscaContacto(String nombre) {
        for(int i = 0; i < numContactos; i++) {
            if(contactos[i].getNombre().equals(nombre)) {
                return i;
            }
        }
        return -1;
    }
    
    public Contacto getContacto(int posicion) {
        if(posicion >= 0 && posicion < numContactos) {
            return contactos[posicion];
        }
        return null;
    }
}