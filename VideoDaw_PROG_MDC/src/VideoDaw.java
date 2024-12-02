import java.time.LocalDate;

public class VideoDaw {
    private String cif;
    private String direccion;
    private LocalDate fechaAlta;
    private Pelicula[] peliculasRegistradas;
    private Cliente[] clientesRegistrados;
    private int totalPeliculas;
    private int totalClientes;

    public VideoDaw(String cif, String direccion) {
        this.cif = cif;
        this.direccion = direccion;
        this.fechaAlta = LocalDate.now();
        this.peliculasRegistradas = new Pelicula[100];
        this.clientesRegistrados = new Cliente[100];
    }

    public Cliente[] getClientesRegistrados() {
        return clientesRegistrados;
    }

    public void registrarPelicula(Pelicula pelicula) {
        if (totalPeliculas < peliculasRegistradas.length) {
            peliculasRegistradas[totalPeliculas++] = pelicula;
            System.out.println("Película registrada con éxito.");
        } else {
            System.out.println("No se pueden registrar más películas.");
        }
    }

    public void registrarCliente(Cliente cliente) {
        if (totalClientes < clientesRegistrados.length) {
            for (int i = 0; i < totalClientes; i++) {
                if (clientesRegistrados[i].getDni().equals(cliente.getDni())) {
                    System.out.println("El cliente ya está registrado.");
                    return;
                }
            }
            clientesRegistrados[totalClientes++] = cliente;
            System.out.println("Cliente registrado con éxito.");
        } else {
            System.out.println("No se pueden registrar más clientes.");
        }
    }

    public boolean alquilarPelicula(String titulo, String dni) {
        Cliente cliente = buscarCliente(dni);
        Pelicula pelicula = buscarPelicula(titulo);

        if (cliente == null || pelicula == null || pelicula.isAlquilada()) {
            System.out.println("No se puede alquilar la película. Verifique los datos.");
            return false;
        }

        pelicula.setAlquilada(true);
        System.out.println("Película alquilada con éxito.");
        return true;
    }

    public boolean devolverPelicula(String titulo) {
        Pelicula pelicula = buscarPelicula(titulo);
        if (pelicula != null && pelicula.isAlquilada()) {
            pelicula.setAlquilada(false);
            System.out.println("Película devuelta con éxito.");
            return true;
        }
        System.out.println("No se pudo devolver la película.");
        return false;
    }

    public void darBajaCliente(Cliente cliente) {
        if (cliente == null) {
            System.out.println("El cliente proporcionado no es válido.");
            return;
        }
    
        boolean clienteEncontrado = false;
    
        for (int i = 0; i < clientesRegistrados.length; i++) {
            if (clientesRegistrados[i] != null && clientesRegistrados[i].equals(cliente)) {
                clientesRegistrados[i] = null;
                clienteEncontrado = true;
                System.out.println("El cliente ha sido dado de baja exitosamente.");
                break;
            }
        }
    
        if (!clienteEncontrado) {
            System.out.println("El cliente no está registrado en el sistema.");
        }
    }

    private Pelicula buscarPelicula(String titulo) {
        for (int i = 0; i < totalPeliculas; i++) {
            if (peliculasRegistradas[i].getTitulo().equalsIgnoreCase(titulo)) {
                return peliculasRegistradas[i];
            }
        }
        return null;
    }

    private Cliente buscarCliente(String dni) {
        for (int i = 0; i < totalClientes; i++) {
            if (clientesRegistrados[i].getDni().equals(dni)) {
                return clientesRegistrados[i];
            }
        }
        return null;
    }

    public void mostrarInfoVideoClub() {
        System.out.println("CIF: " + cif);
        System.out.println("Dirección: " + direccion);
        System.out.println("Fecha de Alta: " + fechaAlta);
    }

    public void mostrarPeliculasRegistradas() {
        System.out.println("=== Películas Registradas ===");
        for (int i = 0; i < totalPeliculas; i++) {
            peliculasRegistradas[i].mostrarInfoPelicula();
        }
    }

    public void mostrarClientesRegistrados() {
        System.out.println("=== Clientes Registrados ===");
        for (int i = 0; i < totalClientes; i++) {
            clientesRegistrados[i].mostrarInfoCliente();
        }
    }
}
