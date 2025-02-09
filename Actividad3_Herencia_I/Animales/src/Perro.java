public class Perro extends Mascotas {
    private String raza;
    private boolean pulgas;
    
    public Perro(String nombre, int edad, String fechaNacimiento, String raza, boolean pulgas) {
        this.nombre = nombre;
        this.edad = edad;
        this.estado = "vivo";
        this.fechaNacimiento = fechaNacimiento;
        this.raza = raza;
        this.pulgas = pulgas;
    }
    
    @Override
    public String muestra() {
    String tienePulgas;
    if (pulgas) {
        tienePulgas = "Sí";
    } else {
        tienePulgas = "No";
    }
    
    return "Perro - Nombre: " + nombre + ", Raza: " + raza + ", Edad: " + edad + 
           ", Estado: " + estado + ", Pulgas: " + tienePulgas;
    }
    
    @Override
    public String habla() {
        return "¡Guau guau!";
    }
}