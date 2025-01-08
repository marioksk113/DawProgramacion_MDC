class Planeta extends Astro {
    private double distanciaAlSol;
    private double periodoTraslacion;
    private Satelite[] satelites;
    private int numSatelites;
    private static final int MAX_SATELITES = 10;

    public Planeta(String nombre, double masa, double diametro, double periodoRotacion, 
                  double temperaturaMedia, double gravedad, double distanciaAlSol, 
                  double periodoTraslacion) {
        super(nombre, masa, diametro, periodoRotacion, temperaturaMedia, gravedad);
        this.distanciaAlSol = distanciaAlSol;
        this.periodoTraslacion = periodoTraslacion;
        this.satelites = new Satelite[MAX_SATELITES];
        this.numSatelites = 0;
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