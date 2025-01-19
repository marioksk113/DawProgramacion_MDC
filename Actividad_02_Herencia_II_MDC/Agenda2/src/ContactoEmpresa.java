class ContactoEmpresa extends Contacto {
    private String paginaWeb;
    
    public ContactoEmpresa(String nombre, String telefono, String paginaWeb) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public String getPaginaWeb() {
        return paginaWeb;
    }
    
    @Override
    public String toString() {
        return "Empresa - Nombre: " + nombre + ", Teléfono: " + telefono + ", Web: " + paginaWeb;
    }
}