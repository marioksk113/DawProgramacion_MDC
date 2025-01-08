class Loro extends Aves {
    private String origen;
    private String habla;
    
    public Loro(String nombre, int edad, String estado, String fechaNacimiento,
                String pico, boolean vuela, String origen, String habla) {
        super(nombre, edad, estado, fechaNacimiento, pico, vuela);
        this.origen = origen;
        this.habla = habla;
    }
    
    public String muestra() {
        return "Loro - Nombre: " + nombre + ", Origen: " + origen;
    }
    
    public void cumpleanios() {
        edad++;
    }
    
    public void morir() {
        estado = "Fallecido";
    }
    
    public String habla() {
        return habla;
    }
    
    public String volar() {
        if (vuela) {
            return "¡El loro está volando!";
        } else {
            return "Este loro no puede volar.";
        }
    }
    
    public String saludar() {
        return "¡Hola! ¿Cómo estás?";
    }
    
    public String mostrarDetalles() {
        return "LORO:\n" +
               "Nombre: " + nombre + "\n" +
               "Edad: " + edad + "\n" +
               "Estado: " + estado + "\n" +
               "Fecha de nacimiento: " + fechaNacimiento + "\n" +
               "Pico: " + pico + "\n" +
               "Vuela: " + (vuela ? "Sí" : "No") + "\n" +
               "Origen: " + origen + "\n" +
               "Habla: " + habla;
    }
}
