
import java.time.LocalDateTime;

public class Movimiento {
    private int id;
    private String fecha;
    private String tipo;
    private double cantidad;

    public Movimiento(int id, String tipo, double cantidad) {
        this.id = id;
        this.fecha = LocalDateTime.now().toString();
        this.tipo = tipo;
        this.cantidad = cantidad;
    }
    public String infoMovimientoString(){
        String infoMovimiento = String.format("ID: %d, Fecha: %s, Tipo: %s, Cantidad: %.2f", this.id, this.fecha, this.tipo, this.cantidad);
        return infoMovimiento;
    }

    public int getid(){ 
        return this.id;
    }

    public String getfecha(){
        return this.fecha;
    }

    public String gettipo(){
        return this.tipo;
    }

    public double getcantidad(){
        return this.cantidad;

    
    }
}
