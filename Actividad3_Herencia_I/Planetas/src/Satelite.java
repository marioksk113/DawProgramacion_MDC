class Satelite extends Astro {
    private double distanciaAlPlaneta;
    private double periodoOrbital;
    private Planeta planetaPertenece;
 
    // Setters para inicializar los valores específicos de Satélite
    public void setDistanciaAlPlaneta(double distanciaAlPlaneta) {
        this.distanciaAlPlaneta = distanciaAlPlaneta;
    }
    
    public void setPeriodoOrbital(double periodoOrbital) {
        this.periodoOrbital = periodoOrbital;
    }
    
    public void setPlanetaPertenece(Planeta planetaPertenece) {
        this.planetaPertenece = planetaPertenece;
    }
 
    @Override
    public String muestra() {
        StringBuilder info = new StringBuilder();
        info.append("\nInformación del satélite ").append(nombre).append("\n");
        info.append("Masa: ").append(masa).append(" kg\n");
        info.append("Diámetro: ").append(diametro).append(" km\n");
        info.append("Periodo de rotación: ").append(periodoRotacion).append(" días\n");
        info.append("Temperatura media: ").append(temperaturaMedia).append(" °C\n");
        info.append("Gravedad: ").append(gravedad).append(" m/s²\n");
        info.append("Distancia al planeta: ").append(distanciaAlPlaneta).append(" km\n");
        info.append("Periodo orbital: ").append(periodoOrbital).append(" días\n");
        info.append("Planeta al que pertenece: ").append(planetaPertenece.getNombre()).append("\n");
        return info.toString();
    }
 }