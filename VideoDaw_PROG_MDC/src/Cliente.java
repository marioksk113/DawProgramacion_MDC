import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Pattern;


public class Cliente {

    private static int max_peliculas = 100;
    private static int contador = 0;

    private String dni;
    private String nombre;
    private int numSocio;
    private String direccion;
    private LocalDate fechaNacimiento;
    private LocalDate fechaBaja;
    private Pelicula[] peliculasAlquiladas;

    public Cliente(String dni, String nombre, String numSocio, String direccion, LocalDate fechaNacimiento, LocalDate fechaBaja) {
        if (!esDniValido(dni)) {
            System.out.println("DNI no válido.");
            return;
        }
        if (!esMayorDeEdad(fechaNacimiento)) {
            System.out.println("El cliente debe ser mayor de edad.");
            return;
        }
        this.numSocio = this.contador;
        
        this.dni = dni;
        this.nombre = nombre;
        this.numSocio = contador;
        this.contador++;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaBaja = fechaBaja;
        this.peliculasAlquiladas = new Pelicula[max_peliculas];
    }

    private boolean esDniValido(String dni) {
        String dniPattern = "^[0-9]{8}[A-Z]$";
        return Pattern.matches(dniPattern, dni);
    }

    private boolean esMayorDeEdad(LocalDate fechaNacimiento) {
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears() >= 18;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumSocio() {
        return numSocio;
    }

    public String setDireccion() {
        return direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public Pelicula[] getPeliculasAlquiladas() {
        return peliculasAlquiladas;
    }

    public void mostrarInfoCliente() {
        System.out.println("Información del Cliente:");
        System.out.println("DNI: " + dni);
        System.out.println("Nombre: " + nombre);
        System.out.println("Número de Socio: " + numSocio);
        System.out.println("Dirección: " + direccion);
        System.out.println("Fecha de Nacimiento: " + fechaNacimiento);
        System.out.println("Fecha de Baja: " + (fechaBaja != null ? fechaBaja : "Activa"));
    }
    
    
    public void mostrarPeliculasAlquiladas() {
        System.out.println("Películas Alquiladas:");
        for (Pelicula pelicula : peliculasAlquiladas) {
            if (pelicula != null) {
                System.out.println("- " + pelicula.getTitulo());
            }
        } 
    }

}