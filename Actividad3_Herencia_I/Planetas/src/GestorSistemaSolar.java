import java.util.Scanner;

class GestorSistemaSolar {
    private Astro[] astros = new Astro[MAX_ASTROS];
    private int numAstros = 0;
    private static final int MAX_ASTROS = 20;
    private Scanner scanner = new Scanner(System.in);

    // Ya no necesitamos constructor, inicializamos los valores en la declaración

    public void inicializarDatos() {

        Planeta tierra = new Planeta();
        tierra.setNombre("Tierra");
        tierra.setMasa(5.972e24);
        tierra.setDiametro(12742);
        tierra.setPeriodoRotacion(1);
        tierra.setTemperaturaMedia(15);
        tierra.setGravedad(9.81);
        tierra.setDistanciaAlSol(149.6e6);
        tierra.setPeriodoTraslacion(365.26);


        Satelite luna = new Satelite();
        luna.setNombre("Luna");
        luna.setMasa(7.349e22);
        luna.setDiametro(3474);
        luna.setPeriodoRotacion(27.32);
        luna.setTemperaturaMedia(-153);
        luna.setGravedad(1.62);
        luna.setDistanciaAlPlaneta(384400);
        luna.setPeriodoOrbital(27.32);
        luna.setPlanetaPertenece(tierra);

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

        Planeta planeta = new Planeta();
        planeta.setNombre(nombre);
        planeta.setMasa(masa);
        planeta.setDiametro(diametro);
        planeta.setPeriodoRotacion(periodoRotacion);
        planeta.setTemperaturaMedia(temperaturaMedia);
        planeta.setGravedad(gravedad);
        planeta.setDistanciaAlSol(distanciaAlSol);
        planeta.setPeriodoTraslacion(periodoTraslacion);

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

        Satelite satelite = new Satelite();
        satelite.setNombre(nombre);
        satelite.setMasa(masa);
        satelite.setDiametro(diametro);
        satelite.setPeriodoRotacion(periodoRotacion);
        satelite.setTemperaturaMedia(temperaturaMedia);
        satelite.setGravedad(gravedad);
        satelite.setDistanciaAlPlaneta(distanciaAlPlaneta);
        satelite.setPeriodoOrbital(periodoOrbital);
        satelite.setPlanetaPertenece(planetaSeleccionado);

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