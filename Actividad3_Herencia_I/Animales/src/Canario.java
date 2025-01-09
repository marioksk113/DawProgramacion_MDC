public class Canario extends Aves {
    private String color;
    private boolean canta;
    
    public Canario(String nombre, int edad, String fechaNacimiento, String color, boolean canta) {
        this.nombre = nombre;
        this.edad = edad;
        this.estado = "vivo";
        this.fechaNacimiento = fechaNacimiento;
        this.color = color;
        this.canta = canta;
        this.pico = "pequeño";
        this.vuela = true;
    }
    
    @Override
    public String muestra() {
        return "Canario - Nombre: " + nombre + ", Color: " + color + ", Edad: " + edad + 
               ", Estado: " + estado + ", Canta: " + (canta ? "Sí" : "No");
    }
    
    @Override
    public String habla() {
        return "¡Pío pío!";
    }
    
    @Override
    public String volar() {
        return "El canario " + nombre + " está volando";
    }
}