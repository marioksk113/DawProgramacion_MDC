import java.time.LocalDate;
import java.time.Period;

public class Cliente {
    private static int contador = 0;

    private String dni;
    private String nombre;
    private String numeroSocio;
    private String direccion;
    private LocalDate fechaNacimiento;
    private LocalDate fechaBaja;
    private Pelicula[] peliculasAlquiladas;

    public Cliente(String dni, String nombre, String direccion, LocalDate fechaNacimiento) {
        if (!esMayorDeEdad(fechaNacimiento) || !esDniValido(dni)) {
            return;
        }
        this.numeroSocio = String.format("S-%04d", ++contador);
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.peliculasAlquiladas = new Pelicula[10];
    }

    private boolean esDniValido(String dni) {
        return dni.matches("\\d{8}[A-Z]");
    }

    private boolean esMayorDeEdad(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroSocio() {
        return numeroSocio;
    }

    public Pelicula[] getPeliculasAlquiladas() {
        return peliculasAlquiladas;
    }

    public void mostrarInfoCliente() {
        System.out.println("=== Información del Cliente ===");
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Número de Socio: " + numeroSocio);
        System.out.println("Dirección: " + direccion);
        System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
        System.out.println("Fecha de Baja: " + (fechaBaja != null ? fechaBaja : "Activa"));
    }

    public void mostrarPeliculasAlquiladas() {
        System.out.println("=== Películas Alquiladas ===");
        for (Pelicula pelicula : peliculasAlquiladas) {
            if (pelicula != null) {
                System.out.println("- " + pelicula.getTitulo());
            }
        }
    }
}