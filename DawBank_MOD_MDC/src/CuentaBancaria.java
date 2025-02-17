import java.util.ArrayList;
import java.util.List;

public class CuentaBancaria {
    private static final double SALDO_MINIMO = -50;
    private static final double LIMITE_HACIENDA = 3000;

    private String numeroCuenta;
    private Cliente cliente;
    private double saldo;
    private List<Movimiento> movimientos;
    private int totalMovimientos;

    public CuentaBancaria(String iban, Cliente cliente) throws CuentaException {
        if (!iban.matches("^[A-Z]{2}[0-9]{22}$")) {
            throw new CuentaException("IBAN no válido. Debe seguir el formato dos letras seguidas de 22 números.");
        }
        if (cliente == null) {
            throw new CuentaException("El cliente no puede ser null.");
        }
        this.numeroCuenta = iban;
        this.cliente = cliente;
        this.saldo = 0.0;
        this.movimientos = new ArrayList<>();
        this.totalMovimientos = 0;
    }

    public String getNumeroCuenta() { return numeroCuenta; }
    public Cliente getCliente() { return cliente; }
    public double getSaldo() { return saldo; }

    public void ingresar(double cantidad) throws CuentaException, AvisarHaciendaException {
        if (cantidad <= 0) {
            throw new CuentaException("La cantidad a ingresar debe ser mayor que cero.");
        }
        
        saldo += cantidad;
        registrarMovimiento("Ingreso", cantidad);

        if (cantidad > LIMITE_HACIENDA) {
            throw new AvisarHaciendaException(cliente.getNombre(), numeroCuenta, "Ingreso de " + cantidad);
        }
    }

    public void retirar(double cantidad) throws CuentaException, AvisarHaciendaException {
        if (cantidad <= 0) {
            throw new CuentaException("La cantidad a retirar debe ser mayor que cero.");
        }
        if (saldo - cantidad < SALDO_MINIMO) {
            throw new CuentaException("Saldo insuficiente. No puede ser menor que " + SALDO_MINIMO + " euros.");
        }
        
        saldo -= cantidad;
        registrarMovimiento("Retirada", cantidad);

        if (cantidad > LIMITE_HACIENDA) {
            throw new AvisarHaciendaException(cliente.getNombre(), numeroCuenta, "Retirada de " + cantidad);
        }
    }

    public List<Movimiento> getMovimientos() {
        return new ArrayList<>(movimientos);
    }

    private void registrarMovimiento(String tipo, double cantidad) {
        movimientos.add(new Movimiento(++totalMovimientos, tipo, cantidad));
    }

    public String mostrarDatosCuenta() {
        return String.format("\n=== DATOS DE LA CUENTA ===\n" +
                           "IBAN: %s\n" +
                           "Cliente: %s\n" +
                           "Saldo: %.2f euros",
                           numeroCuenta, cliente, saldo);
    }
}