public class CuentaBancaria implements DOCUMENTO_REFACTOR {

    private static int max_movs = 100;
    private static double saldo_minimo = -50;
    private static double limite_hacienda = 3000;

    private String numeroCuenta;
    private String titular;
    private double saldo;
    private Movimiento[] movimientos;
    private int totalMovimientos;

    public CuentaBancaria(String numeroCuenta, String titular) {
        if (!numeroCuenta.matches("^[A-Z]{2}[0-9]{22}$")) {
            System.out.println("Error: IBAN no válido. Debe seguir el formato dos letras seguidas de 22 números.");
            return;
        }
        if (titular == null || titular.isEmpty()) {
            System.out.println("Error: El titular no puede estar vacío.");
            return;
        }
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = 0.0000000;
        this.movimientos = new Movimiento[max_movs];
        this.totalMovimientos = 0;
    }

    public String getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public String getTitular() {
        return this.titular;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void mostrarDatosCuenta() {
        System.out.println("\n=== DATOS DE LA CUENTA ===");
        System.out.println("IBAN: " + this.numeroCuenta);
        System.out.println("Titular: " + this.titular);
        System.out.println("Saldo: " + this.saldo + " euros");
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
            System.out.println("Error: Saldo negativo. No puede ser menor que " + saldo_minimo + " euros.");
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

    @Override
	public void mostrarMovimientos() {
        System.out.println("\n=== HISTORIAL DE MOVIMIENTOS ===");
        if (totalMovimientos == 0) {
            System.out.println("No hay movimientos registrados.");
            return;
        }

        for (int i = 0; i < totalMovimientos; i++) {
            System.out.println(movimientos[i].infoMovimientoString());
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
