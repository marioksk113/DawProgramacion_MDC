import java.time.LocalDate;

public class VideoDaw {

    private String cif;
    private String direccion;
    private LocalDate fechaAlta;
    private Pelicula[] peliculasRegistradas;
    private Cliente[] clientesRegistrados;
    private int totalPeliculas;
    private int totalClientes;

    public VideoDaw(String cif, String direccion, LocalDate fechaAlta) {
        if (!esCifValido(cif)) {
            System.out.println("CIF no válido");
            return;
        }
        this.cif = cif;
        this.direccion = direccion;
        this.fechaAlta = fechaAlta;
        this.peliculasRegistradas = new Pelicula[100]; 
        this.clientesRegistrados = new Cliente[100];
        this.totalClientes = 0;
        this.totalPeliculas = 0;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        if (!esCifValido(cif)) {
            System.out.println("CIF no válido");
            return;
        }
        this.cif = cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Pelicula[] getPeliculasRegistradas() {
        return peliculasRegistradas;
    }

    public void setPeliculasRegistradas(Pelicula[] peliculasRegistradas) {
        this.peliculasRegistradas = peliculasRegistradas;
    }

    public Cliente[] getClientesRegistrados() {
        return clientesRegistrados;
    }

    public void setClientesRegistrados(Cliente[] clientesRegistrados) {
        this.clientesRegistrados = clientesRegistrados;
    }

    public int getTotalClientes() {
        return totalClientes;
    }
    
    public void setTotalPeliculas(int totalPeliculas) {
        this.totalPeliculas = totalPeliculas;
    }

    public void setTotalClientes(int totalClientes) {
        this.totalClientes = totalClientes;
    }

    public int getTotalPeliculas() {
        return totalPeliculas;
    }

    private boolean esCifValido(String cif) {
        String cifPattern = "^[A-Z][0-9]{8}$";
        return cif.matches(cifPattern);
    }

    public void mostrarInfoVideoClub() {
        System.out.println("=== Información del VideoClub ===");
        System.out.println("CIF: " + cif);
        System.out.println("Dirección: " + direccion);
        System.out.println("Fecha de Alta: " + fechaAlta);
        System.out.println("Número de Películas Registradas: " + totalPeliculas);
        System.out.println("Número de Clientes Registrados: " + totalClientes);
    }

    public void mostrarPeliculasRegistradas() {
        System.out.println("=== Películas Registradas ===");
        for (int i = 0; i < totalPeliculas; i++) {
            System.out.println(peliculasRegistradas[i].getTitulo());
        }
    }

    public void mostrarClientesRegistrados() {
        System.out.println("=== Clientes Registrados ===");
        for (int i = 0; i < totalClientes; i++) {
            System.out.println(clientesRegistrados[i].getNombre());
        }
    }

    public void alquilarPelicula(Pelicula p, Cliente c) {
        if (p.isAlquilada()) {
            System.out.println("La película ya está alquilada.");
            return;
        }
    
        boolean clienteRegistrado = false;
    
        for (int i = 0; i < totalClientes; i++) {
            if (clientesRegistrados[i].getDni().equals(c.getDni())) {
                clienteRegistrado = true;
                break;
            }
        }
    
        if (!clienteRegistrado) {
            System.out.println("El cliente no está registrado en el videoclub.");
            return;
        }
    
        p.setAlquilada(true);
        System.out.println("Película alquilada con éxito a " + c.getNombre());
    }
    

    public void registrarPelicula(Pelicula p) {
        if (totalPeliculas < peliculasRegistradas.length) {
            peliculasRegistradas[totalPeliculas] = p;
            totalPeliculas++;
        } else {
            System.out.println("No se pueden registrar más películas");
        }
    }

    public void registrarCliente(Cliente c) {
        for (int i = 0; i < totalClientes; i++) {
            if (clientesRegistrados[i].getDni().equals(c.getDni())) {
                System.out.println("El cliente ya está registrado");
                return;
            }
        }

        if (totalClientes < clientesRegistrados.length) {
            clientesRegistrados[totalClientes] = c;
            totalClientes++;
        } else {
            System.out.println("No se pueden registrar más clientes");
        }
    }

}
