abstract class Mascotas {
    protected String nombre;
    protected int edad;
    protected String estado;
    protected String fechaNacimiento;
    
    public Mascotas(String nombre, int edad, String estado, String fechaNacimiento) {
        this.nombre = nombre;
        this.edad = edad;
        this.estado = estado;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    abstract String muestra();
    abstract void cumpleanios();
    abstract void morir();
    abstract String habla();
}

// Clase abstracta Aves
abstract class Aves extends Mascotas {
    protected String pico;
    protected boolean vuela;
    
    public Aves(String nombre, int edad, String estado, String fechaNacimiento, 
                String pico, boolean vuela) {
        super(nombre, edad, estado, fechaNacimiento);
        this.pico = pico;
        this.vuela = vuela;
    }
    
    abstract String volar();
}