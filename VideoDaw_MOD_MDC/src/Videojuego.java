import java.time.LocalDateTime;

public class Videojuego extends Articulo {
    private static int contador = 0;
    
    private Genero genero;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    public Videojuego(String titulo, Genero genero) {
        super(String.format("V-%04d", ++contador), titulo);
        this.genero = genero;
        this.isAlquilada = false;
    }

    public Genero getGenero() {
        return genero;
    }

    public boolean isAlquilada() {
        return isAlquilada;
    }

    public void setAlquilada(boolean alquilada) {
        this.isAlquilada = alquilada;
        this.fechaAlquiler = alquilada ? LocalDateTime.now() : null;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nGénero: " + genero +
               "\n¿Alquilada?: " + (isAlquilada ? "Sí" : "No \n");
    }
}