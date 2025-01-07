abstract class Astro {
    protected double masa;
    protected double diametro;
    protected double periodoRotacion;
    protected double temperaturaMedia;
    protected double gravedad;
    protected String nombre;

    public Astro(String nombre, double masa, double diametro, double periodoRotacion, 
                 double temperaturaMedia, double gravedad) {
        this.nombre = nombre;
        this.masa = masa;
        this.diametro = diametro;
        this.periodoRotacion = periodoRotacion;
        this.temperaturaMedia = temperaturaMedia;
        this.gravedad = gravedad;
    }

    abstract public String muestra();

    public String getNombre() { return nombre; }
    public double getMasa() { return masa; }
    public double getDiametro() { return diametro; }
    public double getPeriodoRotacion() { return periodoRotacion; }
    public double getTemperaturaMedia() { return temperaturaMedia; }
    public double getGravedad() { return gravedad; }
}