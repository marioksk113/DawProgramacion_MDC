import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class GestionAlmacen {
    private LinkedList<Producto> productos;
    private final String ARCHIVO_ALMACEN = "Almacen.dat";
    
    public GestionAlmacen() {
        this.productos = new LinkedList<>();
    }
    
    public String cargarAlmacen() {
        File archivo = new File(ARCHIVO_ALMACEN);
        
        if (archivo.exists()) {
            try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(archivo))) {
                productos = (LinkedList<Producto>) entrada.readObject();
                return "Información del almacén cargada correctamente.";
            } catch (IOException e) {
                return "Error al leer el archivo del almacén: " + e.getMessage();
            } catch (ClassNotFoundException e) {
                return "Error al convertir los datos leídos: " + e.getMessage();
            }
        }
        return "No existe archivo de almacén. Se creará uno nuevo al guardar.";
    }
    
    public String guardarProductos() {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ARCHIVO_ALMACEN))) {
            salida.writeObject(productos);
            return "Información del almacén guardada correctamente.";
        } catch (IOException e) {
            return "Error al guardar en el archivo del almacén: " + e.getMessage();
        }
    }
    
    public String crearProducto(String codigo, String nombre, String cantidadStr, String precioStr) {
        try {
            int cantidad = Integer.parseInt(cantidadStr);
            double precio = Double.parseDouble(precioStr);
            
            if (cantidad < 0) {
                return "Error: La cantidad no puede ser negativa.";
            }
            
            if (precio < 0) {
                return "Error: El precio no puede ser negativo.";
            }
            
            Producto nuevoProducto = new Producto(codigo, nombre, cantidad, precio);
            
            if (existeProducto(codigo)) {
                return "Error: Ya existe un producto con ese código.";
            }
            
            productos.add(nuevoProducto);
            return "Producto añadido correctamente.";
            
        } catch (NumberFormatException e) {
            return "Error: Formato numérico incorrecto.";
        }
    }
    
    public String mostrarProductos() {
        StringBuilder resultado = new StringBuilder("\n=== PRODUCTOS EN ALMACÉN ===\n");
        
        if (productos.isEmpty()) {
            resultado.append("No hay productos en el almacén.");
            return resultado.toString();
        }
        
        resultado.append("Total de productos: ").append(productos.size()).append("\n");
        
        for (Producto p : productos) {
            resultado.append(p.toString()).append("\n");
        }
        
        return resultado.toString();
    }
    
    public String eliminarProducto(String codigo) {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getCodigo().equals(codigo)) {
                productos.remove(i);
                return "Producto eliminado correctamente.";
            }
        }
        return "No se encontró ningún producto con ese código.";
    }
    
    public boolean existeProducto(String codigo) {
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }
}