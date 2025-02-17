public class AvisarHaciendaException extends Exception {
    private String titular;
    private String iban;
    private String operacion;

    public AvisarHaciendaException(String titular, String iban, String operacion) {
        super("Operación que requiere notificación a Hacienda: " + operacion + 
              " en cuenta " + iban + " del titular " + titular);
        this.titular = titular;
        this.iban = iban;
        this.operacion = operacion;
    }

    public String getTitular() { 
        return titular; 
    }

    public String getIban() { 
        return iban; 
    }
    
    public String getOperacion() { 
        return operacion; 
    }
}