
class Satelite extends Astro {
    private double distanciaAlPlaneta;
    private double periodoOrbital;
    private Planeta planetaPertenece;

    public Satelite(String nombre, double masa, double diametro, double periodoRotacion, 
                   double temperaturaMedia, double gravedad, double distanciaAlPlaneta, 
                   double periodoOrbital, Planeta planetaPertenece) {
        super(nombre, masa, diametro, periodoRotacion, temperaturaMedia, gravedad);
        this.distanciaAlPlaneta = distanciaAlPlaneta;
        this.periodoOrbital = periodoOrbital;
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