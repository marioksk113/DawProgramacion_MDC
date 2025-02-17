import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimiento {
    private int id;
    private LocalDateTime fecha;
    private String tipo;
    private double cantidad;

    public Movimiento(int id, String tipo, double cantidad) {
        this.id = id;
        this.fecha = LocalDateTime.now();
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Fecha: %s, Tipo: %s, Cantidad: %.2f",
                           id, fecha.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                           tipo, cantidad);
    }

    public int getId() { return id; }
    public LocalDateTime getFecha() { return fecha; }
    public String getTipo() { return tipo; }
    public double getCantidad() { return cantidad; }
}