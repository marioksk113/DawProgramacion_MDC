class Perro extends Mascotas {
    private String raza;
    private int pulgas;
    
    public Perro(String nombre, int edad, String estado, String fechaNacimiento, 
                 String raza, int pulgas) {
        super(nombre, edad, estado, fechaNacimiento);
        this.raza = raza;
        this.pulgas = pulgas;
    }
    
    public String muestra() {
        return "Perro - Nombre: " + nombre + ", Raza: " + raza;
    }
    
    public void cumpleanios() {
        edad++;
    }
    
    public void morir() {
        estado = "Fallecido";
    }
    
    public String habla() {
        return "¡Guau guau!";
    }
    
    public String mostrarDetalles() {
        return "PERRO:\n" +
               "Nombre: " + nombre + "\n" +
               "Edad: " + edad + "\n" +
               "Estado: " + estado + "\n" +
               "Fecha de nacimiento: " + fechaNacimiento + "\n" +
               "Raza: " + raza + "\n" +
               "Pulgas: " + pulgas;
    }
}
