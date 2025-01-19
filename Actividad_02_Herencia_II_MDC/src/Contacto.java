class Contacto extends Entidad {

    private String nombre;
    private String telefono;
    
    
    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }

    @Override
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }     
    public void setTelefono(String telefono) { this.telefono = telefono; }

    @Override
    public String toString() { return "Nombre: " + nombre + ", Teléfono: " + telefono; }
}