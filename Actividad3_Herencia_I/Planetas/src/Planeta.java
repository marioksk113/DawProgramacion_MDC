class Planeta extends Astro {
    private double distanciaAlSol;
    private double periodoTraslacion;
    private Satelite[] satelites = new Satelite[MAX_SATELITES];
    private int numSatelites = 0;
    private static final int MAX_SATELITES = 10;
    
    // Setters para inicializar los valores específicos de Planeta
    public void setDistanciaAlSol(double distanciaAlSol) {
        this.distanciaAlSol = distanciaAlSol;
    }
    
    public void setPeriodoTraslacion(double periodoTraslacion) {
        this.periodoTraslacion = periodoTraslacion;
    }
    
    public void agregarSatelite(Satelite satelite) {
        if (numSatelites < MAX_SATELITES) {
            satelites[numSatelites] = satelite;
            numSatelites++;
        }
    }
    
    @Override
    public String muestra() {
        StringBuilder info = new StringBuilder();
        info.append("\nInformación del planeta ").append(nombre).append("\n");
        info.append("Masa: ").append(masa).append(" kg\n");
        info.append("Diámetro: ").append(diametro).append(" km\n");
        info.append("Periodo de rotación: ").append(periodoRotacion).append(" días\n");
        info.append("Temperatura media: ").append(temperaturaMedia).append(" °C\n");
        info.append("Gravedad: ").append(gravedad).append(" m/s²\n");
        info.append("Distancia al Sol: ").append(distanciaAlSol).append(" km\n");
        info.append("Periodo de traslación: ").append(periodoTraslacion).append(" días\n");
        
        if (numSatelites > 0) {
            info.append("\nSatélites:\n");
            for (int i = 0; i < numSatelites; i++) {
                info.append(satelites[i].muestra());
            }
        }
        return info.toString();
    }
}