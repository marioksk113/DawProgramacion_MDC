class Producto implements Comparable<Producto> {
    private String nombre;
    private int cantidad;
    
    public Producto(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }
    
    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    public int getCantidad() { 
        return cantidad; 
    }
    public void etCantidad(int cantidad) { 
        this.cantidad = cantidad; 
    }
    
    @Override
    public String toString() {
        return "Producto{nombre='" + nombre + "', cantidad=" + cantidad + "}";
    }
    
    @Override
    public int compareTo(Producto otro) {
        return this.nombre.compareTo(otro.nombre);
    }
}