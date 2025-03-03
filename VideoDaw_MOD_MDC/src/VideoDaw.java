import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;

public class VideoDaw {
    private String cif;
    private String direccion;
    private LocalDate fechaAlta;
    private LinkedList<Articulo> articulosRegistrados;
    private LinkedList<Cliente> clientesRegistrados;

    public VideoDaw(String cif, String direccion) {
        this.cif = cif;
        this.direccion = direccion;
        this.fechaAlta = LocalDate.now();
        this.articulosRegistrados = new LinkedList<>();
        this.clientesRegistrados = new LinkedList<>();
    }

    public LinkedList<Cliente> getClientesRegistrados() {
        return clientesRegistrados;
    }

    public String registrarPelicula(Pelicula pelicula) {
        articulosRegistrados.add(pelicula);
        return "Película registrada con éxito.";
    }

    public String registrarCliente(Cliente cliente) throws ClienteDuplicadoException {
        Cliente clienteExistente = buscarClientePorDni(cliente.getDni());
        if (clienteExistente != null) {
            if (clienteExistente.isActivo()) {
                throw new ClienteDuplicadoException("El cliente con DNI " + cliente.getDni() + " ya está registrado en el sistema.");
            } else {
                clienteExistente.setFechaBaja(null);
                return "Cliente reactivado con éxito.";
            }
        }
        
        clientesRegistrados.add(cliente);
        return "Cliente registrado con éxito.";
    }

    public String alquilarPelicula(String titulo, String dni) throws ClienteBajaException, ArticuloBajaException, ArticuloAlquiladoException {
        Cliente clientePorDni = buscarClientePorDni(dni);
        
        if (clientePorDni == null) {
            return "No se puede alquilar la película. El cliente no existe.";
        }
        
        if (!clientePorDni.isActivo()) {
            throw new ClienteBajaException("El cliente está dado de baja y no puede realizar alquileres.");
        }
        
        Pelicula pelicula = buscarPelicula(titulo);
        Pelicula peliculaPorTitulo = buscarPeliculaPorTitulo(titulo);
        
        if (pelicula == null && peliculaPorTitulo != null) {
            throw new ArticuloBajaException("La película existe pero está dada de baja.");
        }
        
        if (pelicula == null) {
            return "No se puede alquilar la película. La película no existe.";
        }
        
        if (pelicula.isAlquilada()) {
            throw new ArticuloAlquiladoException("La película ya está alquilada por otro cliente.");
        }
        
        pelicula.setAlquilada(true);
        clientePorDni.addArticuloAlquilado(pelicula);
        return "Película alquilada con éxito.";
    }

    public String devolverPelicula(String titulo) throws TiempoExcedidoException {
        Pelicula pelicula = buscarPeliculaPorTitulo(titulo);
        
        if (pelicula == null) {
            return "La película no existe en el videoclub.";
        }

        if (!pelicula.isAlquilada()) {
            return "La película no está alquilada.";
        }

        LocalDateTime fechaAlquiler = pelicula.getFechaAlquiler();
        long horasAlquiladas = ChronoUnit.HOURS.between(fechaAlquiler, LocalDateTime.now());

        if (horasAlquiladas > 48) {
            throw new TiempoExcedidoException("Han pasado " + horasAlquiladas + " horas desde el alquiler. Excede el límite de 48 horas.");
        }

        for (Cliente cliente : clientesRegistrados) {
            if (cliente.getArticulosAlquilados().contains(pelicula)) {
                cliente.removeArticuloAlquilado(pelicula);
                break;
            }
        }

        pelicula.setAlquilada(false);
        return "Película devuelta con éxito.";
    }

    public String darBajaCliente(String dni) {
        Cliente cliente = buscarClientePorDni(dni);
        if (cliente != null) {
            if (cliente.getFechaBaja() != null) {
                return "El cliente ya está dado de baja.";
            }
            
            if (!cliente.getArticulosAlquilados().isEmpty()) {
                return "No se puede dar de baja al cliente porque tiene artículos alquilados pendientes.";
            }
            
            cliente.setFechaBaja(LocalDate.now());
            return "Cliente dado de baja con éxito.";
        }
        return "No se encontró un cliente con ese DNI.";
    }

    public String darBajaPelicula(String titulo) {
        Pelicula pelicula = buscarPeliculaPorTitulo(titulo);
        
        if (pelicula == null) {
            return "La película no existe en el videoclub.";
        }
        
        if (pelicula.getFechaBaja() != null) {
            return "La película ya está dada de baja.";
        }
        
        if (pelicula.isAlquilada()) {
            return "No se puede dar de baja. La película está alquilada.";
        }

        pelicula.setFechaBaja(LocalDate.now());
        return "Película dada de baja con éxito.";
    }
    
    private Pelicula buscarPelicula(String titulo) {
        for (Articulo articulo : articulosRegistrados) {
            if (articulo instanceof Pelicula && 
                articulo.getTitulo().equalsIgnoreCase(titulo) && 
                articulo.getFechaBaja() == null) {
                return (Pelicula) articulo;
            }
        }
        return null;
    }
    
    private Pelicula buscarPeliculaPorTitulo(String titulo) {
        for (Articulo articulo : articulosRegistrados) {
            if (articulo instanceof Pelicula && 
                articulo.getTitulo().equalsIgnoreCase(titulo)) {
                return (Pelicula) articulo;
            }
        }
        return null;
    }

    public Cliente buscarCliente(String dni) {
        for (Cliente cliente : clientesRegistrados) {
            if (cliente.getDni().equals(dni) && cliente.isActivo()) {
                return cliente;
            }
        }
        return null;
    }
    
    public Cliente buscarClientePorDni(String dni) {
        for (Cliente cliente : clientesRegistrados) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
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
        if (articulosRegistrados.isEmpty()) {
            return "No hay películas registradas en el videoclub.";
        }
    
        StringBuilder peliculasInfo = new StringBuilder("=== Películas Registradas ===\n");
        int peliculasActivas = 0;
        int peliculasDadasDeBaja = 0;
    
        for (Articulo articulo : articulosRegistrados) {
            if (articulo instanceof Pelicula) {
                Pelicula pelicula = (Pelicula) articulo;
                
                if (pelicula.getFechaBaja() == null) {
                    peliculasInfo.append("[ACTIVA] ");
                    peliculasActivas++;
                } else {
                    peliculasInfo.append("[BAJA] ");
                    peliculasDadasDeBaja++;
                }
                
                peliculasInfo.append(pelicula.mostrarInfoPelicula()).append("\n");
            }
        }
        
        peliculasInfo.append("\n--- Resumen ---\n");
        peliculasInfo.append("Total películas: ").append(peliculasActivas + peliculasDadasDeBaja).append("\n");
        peliculasInfo.append("Películas activas: ").append(peliculasActivas).append("\n");
        peliculasInfo.append("Películas dadas de baja: ").append(peliculasDadasDeBaja).append("\n");
        
        return peliculasInfo.toString();
    }
    
    public String mostrarClientesRegistrados() {
        if (clientesRegistrados.isEmpty()) {
            return "No hay clientes registrados en el videoclub.";
        }
    
        StringBuilder clientesInfo = new StringBuilder("=== Clientes Registrados ===\n");
        
        int clientesActivos = 0;
        int clientesDadosDeBaja = 0;
        
        java.util.HashSet<String> dniRegistrados = new java.util.HashSet<>();
        StringBuilder duplicados = new StringBuilder();
    
        for (Cliente cliente : clientesRegistrados) {
            if (!dniRegistrados.add(cliente.getDni())) {
                duplicados.append("¡ALERTA! DNI duplicado encontrado: ").append(cliente.getDni()).append("\n");
            }
            
            if (cliente.isActivo()) {
                clientesActivos++;
                clientesInfo.append("[ACTIVO] ");
            } else {
                clientesDadosDeBaja++;
                clientesInfo.append("[BAJA] ");
            }
            
            clientesInfo.append(cliente.mostrarInfoCliente()).append("\n\n");
        }
        
        if (duplicados.length() > 0) {
            clientesInfo.append("\n--- Alertas de duplicación ---\n");
            clientesInfo.append(duplicados);
        }
        
        clientesInfo.append("--- Resumen ---\n");
        clientesInfo.append("Total clientes: ").append(clientesRegistrados.size()).append("\n");
        clientesInfo.append("Clientes activos: ").append(clientesActivos).append("\n");
        clientesInfo.append("Clientes dados de baja: ").append(clientesDadosDeBaja).append("\n");
        
        return clientesInfo.toString();
    }
}