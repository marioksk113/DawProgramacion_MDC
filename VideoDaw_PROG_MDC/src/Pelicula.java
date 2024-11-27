import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pelicula {
    
    private static int contador = 0;

    private int id;
    private String titulo;
    private Genero genero;
    private String fechaRegistro;
    private String fechaBaja;
    private String fechaAlquiler;
    private boolean isAlquilada;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM HH:mm");

    public Pelicula(String titulo, Genero genero){
        this.id = this.contador;
        this.contador++;
        this.titulo = titulo;
        this.genero = genero;
        this.fechaRegistro = LocalDateTime.now().format(formatter);
        this.isAlquilada = false;
    }


    public static int getContador() {
        return contador;
    }
    public int getidPelicula() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public Genero getGenero() {
        return genero;
    }
    public String getfechafechaRegistro() {
        return fechaRegistro;
    }
    public String getfechafechaBaja() {
        return fechaBaja;
    }
    public String getfechafechaAlquiler() {
        return fechaAlquiler;
    }
    public boolean isAlquilada() {
        return isAlquilada;
    }

    public String mostrarCodigoPelicula(){
        String codigoPelicula = "Pel-0" + contador;
        return codigoPelicula;
    }
    public String mostrarInfoPelicula(){
        String getInfoPelicula = String.format("ID-0%s, Titulo: %s, Genero: %s, fechaRegistro: %s, fechaBaja: %s, fechaAlquiler: %s, ¿Alquilada? %s",
               this.id, this.titulo, this.genero, this.fechaRegistro, this.fechaBaja, this.fechaAlquiler, this.isAlquilada);

        return getInfoPelicula;
    }

    public void setAlquilada(boolean alquilada) {
        this.isAlquilada = alquilada;}

}