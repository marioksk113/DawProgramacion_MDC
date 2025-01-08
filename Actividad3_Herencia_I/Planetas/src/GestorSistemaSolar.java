import java.util.Scanner;

class GestorSistemaSolar {
    private Astro[] astros;
    private int numAstros;
    private static final int MAX_ASTROS = 20;
    private Scanner scanner;

    public GestorSistemaSolar() {
        astros = new Astro[MAX_ASTROS];
        numAstros = 0;
        scanner = new Scanner(System.in);
        inicializarDatosEjemplo();
    }

    private void inicializarDatosEjemplo() {
        Planeta tierra = new Planeta("Tierra", 5.972e24, 12742, 1, 15, 9.81, 149.6e6, 365.26);
        Satelite luna = new Satelite("Luna", 7.349e22, 3474, 27.32, -153, 1.62, 384400, 27.32, tierra);
        tierra.agregarSatelite(luna);
        agregarAstro(tierra);
        agregarAstro(luna);
    }

    private void agregarAstro(Astro astro) {
        if (numAstros < MAX_ASTROS) {
            astros[numAstros] = astro;
            numAstros++;
        }
    }

    public String listarAstros() {
        StringBuilder lista = new StringBuilder("\nAstros disponibles:\n");
        for (int i = 0; i < numAstros; i++) {
            lista.append((i+1)).append(". ").append(astros[i].getNombre()).append("\n");
        }
        return lista.toString();
    }

    public String mostrarAstro(int indice) {
        if (indice >= 0 && indice < numAstros) {
            return astros[indice].muestra();
        }
        return "Índice no válido";
    }

    public String agregarPlaneta(String nombre, double masa, double diametro, 
                                double periodoRotacion, double temperaturaMedia, 
                                double gravedad, double distanciaAlSol, 
                                double periodoTraslacion) {
        if (numAstros >= MAX_ASTROS) {
            return "No se pueden agregar más astros";
        }

        Planeta planeta = new Planeta(nombre, masa, diametro, periodoRotacion, 
                                    temperaturaMedia, gravedad, distanciaAlSol, 
                                    periodoTraslacion);
        agregarAstro(planeta);
        return "Planeta agregado correctamente";
    }

    public String agregarSatelite(String nombre, double masa, double diametro, 
                                 double periodoRotacion, double temperaturaMedia, 
                                 double gravedad, double distanciaAlPlaneta, 
                                 double periodoOrbital, int indicePlaneta) {
        if (numAstros >= MAX_ASTROS) {
            return "No se pueden agregar más astros";
        }

        // Obtener planeta seleccionado
        Planeta planetaSeleccionado = null;
        int numPlanetas = 0;
        for (int i = 0; i < numAstros && numPlanetas <= indicePlaneta; i++) {
            if (astros[i] instanceof Planeta) {
                if (numPlanetas == indicePlaneta) {
                    planetaSeleccionado = (Planeta)astros[i];
                }
                numPlanetas++;
            }
        }

        if (planetaSeleccionado == null) {
            return "Planeta no encontrado";
        }

        Satelite satelite = new Satelite(nombre, masa, diametro, periodoRotacion, 
                                        temperaturaMedia, gravedad, distanciaAlPlaneta, 
                                        periodoOrbital, planetaSeleccionado);
        planetaSeleccionado.agregarSatelite(satelite);
        agregarAstro(satelite);
        return "Satélite agregado correctamente";
    }

    public String listarPlanetas() {
        StringBuilder lista = new StringBuilder("\nPlanetas disponibles:\n");
        int numPlanetas = 0;
        for (int i = 0; i < numAstros; i++) {
            if (astros[i] instanceof Planeta) {
                lista.append((numPlanetas + 1)).append(". ")
                     .append(astros[i].getNombre()).append("\n");
                numPlanetas++;
            }
        }
        if (numPlanetas == 0) {
            return "No hay planetas disponibles. Agregue un planeta primero.";
        }
        return lista.toString();
    }
    
}
