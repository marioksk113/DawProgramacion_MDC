class Gato extends Mascotas {
    private String color;
    private String peloLargo;
    
    public Gato(String nombre, int edad, String estado, String fechaNacimiento, 
                String color, String peloLargo) {
        super(nombre, edad, estado, fechaNacimiento);
        this.color = color;
        this.peloLargo = peloLargo;
    }
    
    public String muestra() {
        return "Gato - Nombre: " + nombre + ", Color: " + color;
    }
    
    public void cumpleanios() {
        edad++;
    }
    
    public void morir() {
        estado = "Fallecido";
    }
    
    public String habla() {
        return "¡Miau miau!";
    }
    
    public String mostrarDetalles() {
        return "GATO:\n" +
               "Nombre: " + nombre + "\n" +
               "Edad: " + edad + "\n" +
               "Estado: " + estado + "\n" +
               "Fecha de nacimiento: " + fechaNacimiento + "\n" +
               "Color: " + color + "\n" +
               "Pelo largo: " + peloLargo;
    }
}