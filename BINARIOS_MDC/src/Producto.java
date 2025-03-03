import java.io.Serializable;

public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto() {
    }

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        } else {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad >= 0) {
            this.cantidad = cantidad;
        } else {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
    }

    @Override
    public String toString() {
        return "Producto{" +
               "nombre='" + nombre + '\'' +
               ", precio=" + precio +
               ", cantidad=" + cantidad +
               '}';
    }
}