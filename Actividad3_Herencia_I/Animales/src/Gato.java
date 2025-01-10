public class Gato extends Mascotas {
    private String color;
    private boolean peloLargo;
    
    public Gato(String nombre, int edad, String fechaNacimiento, String color, boolean peloLargo) {
        this.nombre = nombre;
        this.edad = edad;
        this.estado = "vivo";
        this.fechaNacimiento = fechaNacimiento;
        this.color = color;
        this.peloLargo = peloLargo;
    }
    
    @Override
    public String muestra() {
    String tipoPelo;
    if (peloLargo) {
        tipoPelo = "Sí";
    } else {
        tipoPelo = "No";
    }
    
    return "Gato - Nombre: " + nombre + ", Color: " + color + ", Edad: " + edad + 
           ", Estado: " + estado + ", Pelo largo: " + tipoPelo;
    }
    
    @Override
    public String habla() {
        return "¡Miau miau!";
    }
}