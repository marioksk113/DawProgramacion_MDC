public class Utilidades {

    // Método para validar el formato del DNI
    public static boolean validarDNI(String dni) {
        return dni.matches("\\d{8}[A-Z]");
    }

    // Método para validar el formato de una fecha (YYYY-MM-DD)
    public static boolean validarFecha(String fecha) {
        String regexFecha = "\\d{4}-\\d{2}-\\d{2}";
        return fecha.matches(regexFecha);
    }
}