class Canario extends Aves {
    private String color;
    private String canta;
    
    public Canario(String nombre, int edad, String estado, String fechaNacimiento,
                   String pico, boolean vuela, String color, String canta) {
        super(nombre, edad, estado, fechaNacimiento, pico, vuela);
        this.color = color;
        this.canta = canta;
    }
    
    public String muestra() {
        return "Canario - Nombre: " + nombre + ", Color: " + color;
    }
    
    public void cumpleanios() {
        edad++;
    }
    
    public void morir() {
        estado = "Fallecido";
    }
    
    public String habla() {
        return canta;
    }
    
    public String volar() {
        if (vuela) {
            return "¡El canario está volando!";
        } else {
            return "Este canario no puede volar.";
        }
    }
    public String mostrarDetalles() {
        return "CANARIO:\n" +
               "Nombre: " + nombre + "\n" +
               "Edad: " + edad + "\n" +
               "Estado: " + estado + "\n" +
               "Fecha de nacimiento: " + fechaNacimiento + "\n" +
               "Pico: " + pico + "\n" +
               "Vuela: " + (vuela ? "Sí" : "No") + "\n" +
               "Color: " + color + "\n" +
               "Canta: " + canta;
    }
}