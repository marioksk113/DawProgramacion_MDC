import java.io.Serializable;

public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String codigo;
    private String nombre;
    private int cantidad;
    private double precio;
    
    public Producto() {
    }
    
    public Producto(String codigo, String nombre, int cantidad, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
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
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public double getValorTotal() {
        return precio * cantidad;
    }
    
    @Override
    public String toString() {
        return "Código: " + codigo + 
               ", Nombre: " + nombre + 
               ", Cantidad: " + cantidad + 
               ", Precio: " + String.format("%.2f", precio) + " Euros" +
               ", Valor total: " + String.format("%.2f", getValorTotal()) + " Euros";
    }
}
