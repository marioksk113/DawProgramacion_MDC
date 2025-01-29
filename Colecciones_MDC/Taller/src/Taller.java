import java.util.HashMap;
import java.util.Map;

public class Taller {
    private HashMap<String, Coche> coches = new HashMap<String, Coche>();

    public String añadirCoche(String matricula, String marca, String color) {
        if (coches.containsKey(matricula)) {
            return "Error: Ya existe un coche con esa matrícula";
        }

        if (!matricula.matches("\\d{4}[A-Z]{3}")) {
            return "Error: Formato de matrícula inválido";
        }

        coches.put(matricula, new Coche(color, marca));
        return "Coche añadido correctamente";
    }

    public String eliminarCoche(String matricula) {
        if (coches.remove(matricula) == null) {
            return "Error: No existe ningún coche con esa matrícula";
        }
        return "Coche eliminado correctamente";
    }

    public HashMap<String, String> visualizarMatriculas() {
        HashMap<String, String> matriculas = new HashMap<>();
        for (String matricula : coches.keySet()) {
            matriculas.put(matricula, "Matrícula registrada");
        }
        return matriculas;
    }
    public HashMap<String, String> visualizarCoches() {
        HashMap<String, String> datosCoches = new HashMap<>();
        for (Coche coche : coches.values()) {
            datosCoches.put(coche.getMarca(), coche.getColor());
        }
        return datosCoches;
    }

    public HashMap<String, String> visualizarTaller() {
        HashMap<String, String> datosTaller = new HashMap<>();
        for (Map.Entry<String, Coche> entry : coches.entrySet()) {
            String matricula = entry.getKey();
            Coche coche = entry.getValue();
            datosTaller.put(matricula, coche.getMarca() + " - " + coche.getColor());
        }
        return datosTaller;
    }
}
