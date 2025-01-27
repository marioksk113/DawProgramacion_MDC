import java.util.HashMap;

public class Taller {
    private HashMap<String, Coche> coches = new HashMap<String, Coche>();

    public void añadirCoche(String matricula, String marca, String color) {
        Coche nuevoCoche = new Coche(color, marca);
        coches.put(matricula, nuevoCoche);
    }

    public void eliminarCoche(String matricula) {
        coches.remove(matricula);
    }

    public void visualizarMatriculas() {
        for (String matricula : coches.keySet()) {
            System.out.println("Matrícula: " + matricula);
        }
    }

    public void visualizarCoches() {
        for (Coche coche : coches.values()) {
            System.out.println(coche);
        }
    }

    public void visualizarTaller() {
        for (HashMap.Entry<String, Coche> entry : coches.entrySet()) {
            System.out.println("Matrícula: " + entry.getKey() + " - " + entry.getValue());
        }
    }
}
