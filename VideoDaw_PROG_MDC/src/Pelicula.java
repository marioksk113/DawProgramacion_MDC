import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pelicula {
    private static int contador = 0;

    private String codigo;
    private String titulo;
    private Genero genero;
    private LocalDate fechaRegistro;
    private LocalDate fechaBaja;
    private LocalDateTime fechaAlquiler;
    private boolean isAlquilada;

    public Pelicula(String titulo, Genero genero) {
        this.codigo = String.format("P-%04d", ++contador);
        this.titulo = titulo;
        this.genero = genero;
        this.fechaRegistro = LocalDate.now();
        this.isAlquilada = false;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
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

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public LocalDateTime getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public String mostrarInfoPelicula() {
        return "Código: " + codigo +
               "\nTítulo: " + titulo +
               "\nGénero: " + genero +
               "\nFecha de Registro: " + fechaRegistro +
               "\nFecha de Baja: " + (fechaBaja != null ? fechaBaja : "No aplica") +
               "\n¿Alquilada?: " + (isAlquilada ? "Sí" : "No \n");
               
    }    
}
