import java.time.LocalDate;

public class Cliente extends Persona {
    private String telefono;
    private String email;
    private String direccion;

    public Cliente(String nombre, String dni, LocalDate fechaNacimiento,
                  String telefono, String email, String direccion) {
        super(nombre, dni, fechaNacimiento);
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return String.format("Cliente: %s, DNI: %s, Fecha Nacimiento: %s, " +
                           "Teléfono: %s, Email: %s, Dirección: %s",
                           nombre, dni, fechaNacimiento, telefono, email, direccion);
    }
}