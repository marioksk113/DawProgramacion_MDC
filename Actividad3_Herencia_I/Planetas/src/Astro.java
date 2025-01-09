abstract class Astro {
    protected double masa;
    protected double diametro;
    protected double periodoRotacion;
    protected double temperaturaMedia;
    protected double gravedad;
    protected String nombre;

    abstract public String muestra();


    public String getNombre() { return nombre; }
    public double getMasa() { return masa; }
    public double getDiametro() { return diametro; }
    public double getPeriodoRotacion() { return periodoRotacion; }
    public double getTemperaturaMedia() { return temperaturaMedia; }
    public double getGravedad() { return gravedad; }

    protected void setNombre(String nombre) { this.nombre = nombre; }
    protected void setMasa(double masa) { this.masa = masa; }
    protected void setDiametro(double diametro) { this.diametro = diametro; }
    protected void setPeriodoRotacion(double periodoRotacion) { this.periodoRotacion = periodoRotacion; }
    protected void setTemperaturaMedia(double temperaturaMedia) { this.temperaturaMedia = temperaturaMedia; }
    protected void setGravedad(double gravedad) { this.gravedad = gravedad; }
}