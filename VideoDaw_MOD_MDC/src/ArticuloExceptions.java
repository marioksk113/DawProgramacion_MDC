class ArticuloException extends Exception {
    public ArticuloException(String mensaje) {
        super(mensaje);
    }
}

class ArticuloAlquiladoException extends ArticuloException {
    public ArticuloAlquiladoException(String mensaje) {
        super(mensaje);
    }
}

class ArticuloBajaException extends ArticuloException {
    public ArticuloBajaException(String mensaje) {
        super(mensaje);
    }
}