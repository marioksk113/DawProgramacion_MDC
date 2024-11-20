
public class CuentaBancaria {

    private static int max_movs = 100;
    private static double saldo_minimo = -50;
    private static double limite_hacienda = 3000;

    private String iban;
    private String titular;
    private double saldo;
    private Movimiento[] movimientos;
    private int totalMovimientos;

    public CuentaBancaria(String iban, String titular) {
        if (!iban.matches("^[A-Z]{2}[0-9]{22}$")) {
            System.out.println("Error: IBAN no válido. Debe seguir el formato dos letras seguidas de 22 números.");
            return;
        }
        if (titular == null || titular.isEmpty()) {
            System.out.println("Error: El titular no puede estar vacío.");
            return;
        }
        this.iban = iban;
        this.titular = titular;
        this.saldo = 0.0000000;
        this.movimientos = new Movimiento[max_movs];
        this.totalMovimientos = 0;
    }

    public String getIban() {
        return this.iban;
    }

    public String getTitular() {
        return this.titular;
    }

    public int getTotalMovimientos() {
        return this.totalMovimientos;
    }

    public Movimiento[] getMovimientos() {
         return this.movimientos; }

    public double getSaldo() {
        return this.saldo;
    }

    public void ingresar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("Error: La cantidad a ingresar debe ser mayor que cero.");
            return;
        }
        saldo += cantidad;
        registrarMovimiento("Ingreso", cantidad);
        if (cantidad > limite_hacienda) {
            System.out.println("AVISO: Notificar a hacienda");
        }
    }

    public void retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("Error: La cantidad a retirar debe ser mayor que cero.");
            return;
        }
        if (saldo - cantidad < saldo_minimo) {
            System.out.println("Error: Saldo insuficiente. No puede ser menor que " + saldo_minimo + " euros.");
            return;
        }
        saldo -= cantidad;
        registrarMovimiento("Retirada", cantidad);
        if (saldo < 0) {
            System.out.println("AVISO: Saldo negativo");
        }
        if (cantidad > limite_hacienda) {
            System.out.println("AVISO: Notificar a hacienda");
        }
    }

    private void registrarMovimiento(String tipo, double cantidad) {
        if (totalMovimientos >= max_movs) {
            System.arraycopy(movimientos, 1, movimientos, 0, max_movs - 1);
            totalMovimientos--;
        }
        movimientos[totalMovimientos] = new Movimiento(totalMovimientos + 1, tipo, cantidad);
        totalMovimientos++;
    }

    
}

