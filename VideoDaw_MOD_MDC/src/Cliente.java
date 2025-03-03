import java.time.LocalDate;
import java.util.LinkedList;

public class Cliente extends Persona {
    private static int contador = 0;

    private String numeroSocio;
    private LocalDate fechaBaja;
    private LinkedList<Articulo> articulosAlquilados;

    public Cliente(String dni, String nombre, String direccion, LocalDate fechaNacimiento) {
        super(dni, nombre, direccion, fechaNacimiento);
        this.numeroSocio = String.format("S-%04d", ++contador);
        this.articulosAlquilados = new LinkedList<>();
    }

    public String getNumeroSocio() {
        return numeroSocio;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
    
    public boolean isActivo() {
        return fechaBaja == null;
    }

    public LinkedList<Articulo> getArticulosAlquilados() {
        return articulosAlquilados;
    }
    
    public void addArticuloAlquilado(Articulo articulo) {
        articulosAlquilados.add(articulo);
    }
    
    public void removeArticuloAlquilado(Articulo articulo) {
        articulosAlquilados.remove(articulo);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "Número de Socio: " + numeroSocio + "\n" +
               "Fecha de Baja: " + (fechaBaja != null ? fechaBaja : "Activa");
    }
    
    public String mostrarInfoCliente() {
        return toString();
    }

    public String mostrarArticulosAlquilados() {
        StringBuilder resultado = new StringBuilder("Artículos alquilados por " + nombre + ":\n");
        
        if (articulosAlquilados.isEmpty()) {
            resultado.append("No tiene artículos alquilados actualmente.\n");
        } else {
            for (Articulo articulo : articulosAlquilados) {
                resultado.append("- ").append(articulo.getTitulo()).append("\n");
            }
        }
        
        return resultado.toString();
    }
}