import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Persona implements Serializable {
    protected String dni;
    protected String nombre;
    protected String direccion;
    protected LocalDate fechaNacimiento;

    public Persona(String dni, String nombre, String direccion, LocalDate fechaNacimiento) {
        if (!esDniValido(dni) || !esMayorDeEdad(fechaNacimiento)) {
            throw new IllegalArgumentException("DNI no válido o persona menor de edad");
        }
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }

    protected boolean esDniValido(String dni) {
        return dni.matches("\\d{8}[A-Z]");
    }

    protected boolean esMayorDeEdad(LocalDate fechaNacimiento) {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    @Override
    public String toString() {
        return "DNI: " + dni + "\n" +
               "Nombre: " + nombre + "\n" +
               "Dirección: " + direccion + "\n" +
               "Fecha de Nacimiento: " + fechaNacimiento;
    }
}