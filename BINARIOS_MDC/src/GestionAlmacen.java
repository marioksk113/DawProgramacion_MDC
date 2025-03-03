import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class GestionAlmacen {
    private List<Producto> productos;
    private static final String ARCHIVO_ALMACEN = "Almacen.dat";

    public GestionAlmacen() {
        this.productos = new LinkedList<>();
        cargarDatos();
    }

    public void cargarDatos() {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(ARCHIVO_ALMACEN))) {
            productos = (List<Producto>) entrada.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de almacén. Se creará uno nuevo.");
            productos = new LinkedList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
            productos = new LinkedList<>();
        }
    }

    public void guardarDatos() {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(ARCHIVO_ALMACEN))) {
            salida.writeObject(productos);
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public boolean eliminarProducto(String nombre) {
        return productos.removeIf(p -> p.getNombre().equals(nombre));
    }

    public Producto buscarProducto(String nombre) {
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        return null;
    }

    public boolean actualizarCantidad(String nombre, int nuevaCantidad) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            producto.setCantidad(nuevaCantidad);
            return true;
        }
        return false;
    }

    public void mostrarProductos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos en el almacén.");
            return;
        }
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }

    public double calcularValorInventario() {
        return productos.stream()
                .mapToDouble(p -> p.getPrecio() * p.getCantidad())
                .sum();
    }
}