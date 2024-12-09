import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

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

    public String registrarPelicula(Pelicula pelicula) {
        if (totalPeliculas < peliculasRegistradas.length) {
            peliculasRegistradas[totalPeliculas++] = pelicula;
            return "Película registrada con éxito.";
        } else {
            return "No se pueden registrar más películas.";
        }
    }

    public String registrarCliente(Cliente cliente) {
        if (totalClientes < clientesRegistrados.length) {
            for (int i = 0; i < totalClientes; i++) {
                if (clientesRegistrados[i].getDni().equals(cliente.getDni())) {
                    return "El cliente ya está registrado.";
                }
            }
            clientesRegistrados[totalClientes++] = cliente;
            return "Cliente registrado con éxito.";
        } else {
            return "No se pueden registrar más clientes.";
        }
    }

    public String alquilarPelicula(String titulo, String dni) {
        Cliente cliente = buscarCliente(dni);
        Pelicula pelicula = buscarPelicula(titulo);
    
        if (cliente == null || pelicula == null || pelicula.isAlquilada()) {
            return "No se puede alquilar la película. Verifique los datos.";
        }
    
        pelicula.setAlquilada(true);
        return "Película alquilada con éxito.";
    }

    public String devolverPelicula(String titulo) {
        Pelicula pelicula = buscarPelicula(titulo);
        if (pelicula == null) {
            return "La película no existe en el videoclub.";
        }

        if (!pelicula.isAlquilada()) {
            return "La película no está alquilada.";
        }

        LocalDateTime fechaAlquiler = pelicula.getFechaAlquiler();
        long horasAlquiladas = ChronoUnit.HOURS.between(fechaAlquiler, LocalDateTime.now());

        if (horasAlquiladas > 48) {
            return "Advertencia: Han pasado más de 48 horas desde que alquilaste la película. Por favor, devuelve las películas a tiempo.";
        }

        pelicula.setAlquilada(false);
        return "Película devuelta con éxito.";
    }

    public String darBajaCliente(String dni) {
        Cliente cliente = buscarCliente(dni);
        if (cliente != null) {
            for (int i = 0; i < totalClientes; i++) {
                if (clientesRegistrados[i] != null && clientesRegistrados[i].getDni().equals(dni)) {
                    clientesRegistrados[i] = null;
                    return "Cliente dado de baja con éxito.";
                }
            }
        }
        return "No se encontró un cliente con ese DNI.";
    }

    public String darBajaPelicula(String titulo) {
        Pelicula pelicula = buscarPelicula(titulo);
        if (pelicula == null) {
            return "La película no existe en el videoclub.";
        }
        
        if (pelicula.isAlquilada()) {
            return "No se puede dar de baja. La película está alquilada.";
        }

        pelicula.setFechaBaja(LocalDate.now());
        return "Película dada de baja con éxito.";
    }
    
    private Pelicula buscarPelicula(String titulo) {
        for (int i = 0; i < totalPeliculas; i++) {
            if (peliculasRegistradas[i].getTitulo().equalsIgnoreCase(titulo)) {
                return peliculasRegistradas[i];
            }
        }
        return null;
    }

    public Cliente buscarCliente(String dni) {
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

    public String mostrarPeliculasRegistradas() {
        if (totalPeliculas == 0) {
            return "No hay películas registradas en el videoclub.";
        }
    
        StringBuilder peliculasInfo = new StringBuilder("=== Películas Registradas ===\n");
    
        for (int i = 0; i < totalPeliculas; i++) {
            Pelicula pelicula = peliculasRegistradas[i];
            if (pelicula != null) {
                peliculasInfo.append(pelicula.mostrarInfoPelicula()).append("\n");
            }
        }
        return peliculasInfo.toString();
    }
}
