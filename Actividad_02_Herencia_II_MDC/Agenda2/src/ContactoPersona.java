class ContactoPersona extends Contacto {
    private String cumpleaños;
    
    public ContactoPersona(String nombre, String telefono, String cumpleaños) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.cumpleaños = cumpleaños;
    }
    
    @Override
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
    public String getCumpleaños() { return cumpleaños; }
    
    @Override
    public String toString() {
        return "Persona - Nombre: " + nombre + ", Teléfono: " + telefono + ", Cumpleaños: " + cumpleaños;
    }
}