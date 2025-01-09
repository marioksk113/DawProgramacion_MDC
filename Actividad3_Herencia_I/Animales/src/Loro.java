public class Loro extends Aves {
    private String origen;
    private String habla;
    
    public Loro(String nombre, int edad, String fechaNacimiento, String origen, String habla) {
        this.nombre = nombre;
        this.edad = edad;
        this.estado = "vivo";
        this.fechaNacimiento = fechaNacimiento;
        this.origen = origen;
        this.habla = habla;
        this.pico = "curvo";
        this.vuela = true;
    }
    
    @Override
    public String muestra() {
        return "Loro - Nombre: " + nombre + ", Origen: " + origen + ", Edad: " + edad + 
               ", Estado: " + estado;
    }
    
    @Override
    public String habla() {
        return habla;
    }
    
    public String saluda() {
        return "¡Hola, soy un loro!";
    }
    
    @Override
    public String volar() {
        return "El loro " + nombre + " está volando";
    }
}