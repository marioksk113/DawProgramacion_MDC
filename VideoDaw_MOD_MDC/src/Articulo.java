import java.io.Serializable;
import java.time.LocalDate;

public abstract class Articulo implements Serializable {
    private String codigo;
    private String titulo;
    private LocalDate fechaRegistro;
    private LocalDate fechaBaja;

    public Articulo(String codigo, String titulo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.fechaRegistro = LocalDate.now();
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }
    
    public LocalDate getFechaBaja() {
        return fechaBaja;
    }
    
    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
    
    public String toString() {
        return "Código: " + codigo + 
               "\nTítulo: " + titulo + 
               "\nFecha de Registro: " + fechaRegistro + 
               "\nFecha de Baja: " + (fechaBaja != null ? fechaBaja : "No aplica");
    }
}