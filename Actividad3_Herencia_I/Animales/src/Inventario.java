class Inventario {
    private Mascotas[] animales;
    private int numAnimales;
    private static final int MAX_ANIMALES = 100;
    
    public Inventario() {
        animales = new Mascotas[MAX_ANIMALES];
        numAnimales = 0;
    }
    
    public String mostrarListaAnimales() {
        if (numAnimales == 0) {
            return "No hay animales en el inventario.";
        }
        
        StringBuilder lista = new StringBuilder();
        for (int i = 0; i < numAnimales; i++) {
            lista.append(animales[i].muestra()).append("\n");
        }
        return lista.toString();
    }
    
    public String mostrarAnimal(int index) {
        if (index >= 0 && index < numAnimales) {
            Mascotas animal = animales[index];
            if (animal instanceof Perro) {
                Perro perro = (Perro) animal;
                return perro.mostrarDetalles();
            } else if (animal instanceof Gato) {
                Gato gato = (Gato) animal;
                return gato.mostrarDetalles();
            } else if (animal instanceof Loro) {
                Loro loro = (Loro) animal;
                return loro.mostrarDetalles();
            } else if (animal instanceof Canario) {
                Canario canario = (Canario) animal;
                return canario.mostrarDetalles();
            }
        }
        return "Índice no válido";
    }
    
    public String mostrarTodosAnimales() {
        if (numAnimales == 0) {
            return "No hay animales en el inventario.";
        }
        
        StringBuilder todos = new StringBuilder();
        for (int i = 0; i < numAnimales; i++) {
            todos.append("\nAnimal #").append(i+1).append("\n");
            todos.append(mostrarAnimal(i)).append("\n");
        }
        return todos.toString();
    }
    
    public boolean insertarAnimal(Mascotas animal) {
        if (numAnimales < MAX_ANIMALES) {
            animales[numAnimales] = animal;
            numAnimales++;
            return true;
        }
        return false;
    }
    
    public boolean eliminarAnimal(int index) {
        if (index >= 0 && index < numAnimales) {
            for (int i = index; i < numAnimales - 1; i++) {
                animales[i] = animales[i + 1];
            }
            animales[numAnimales - 1] = null;
            numAnimales--;
            return true;
        }
        return false;
    }
    
    public void vaciarInventario() {
        for (int i = 0; i < numAnimales; i++) {
            animales[i] = null;
        }
        numAnimales = 0;
    }
}