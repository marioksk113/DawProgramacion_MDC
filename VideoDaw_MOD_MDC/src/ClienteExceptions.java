class ClienteException extends Exception {
    public ClienteException(String mensaje) {
        super(mensaje);
    }
}

class ClienteDuplicadoException extends ClienteException {
    public ClienteDuplicadoException(String mensaje) {
        super(mensaje);
    }
}

class ClienteBajaException extends ClienteException {
    public ClienteBajaException(String mensaje) {
        super(mensaje);
    }
}