public class Inventario {
    private Mascotas[] animales;
    private int numAnimales;
    private final int MAX_ANIMALES = 100;
    
    public Inventario() {
        animales = new Mascotas[MAX_ANIMALES];
        numAnimales = 0;
    }
    
    public String mostrarListaAnimales() {
        StringBuilder lista = new StringBuilder();
        for(int i = 0; i < numAnimales; i++) {
            lista.append(i).append(". ")
                .append(animales[i].getClass().getSimpleName())
                .append(" - ")
                .append(animales[i].nombre)
                .append("\n");
        }
        return lista.toString();
    }
    
    public String mostrarAnimal(int indice) {
        if(indice >= 0 && indice < numAnimales) {
            return animales[indice].muestra();
        }
        return "Índice no válido";
    }
    
    public String mostrarTodosAnimales() {
        if(numAnimales == 0) {
            return "No hay animales en el inventario";
        }
        StringBuilder todos = new StringBuilder();
        for(int i = 0; i < numAnimales; i++) {
            todos.append(i).append(". ")
                .append(animales[i].muestra())
                .append("\n");
        }
        return todos.toString();
    }
    
    public String insertarAnimal(Mascotas animal) {
        if(numAnimales < MAX_ANIMALES) {
            animales[numAnimales] = animal;
            numAnimales++;
            return "Animal añadido correctamente";
        }
        return "Inventario lleno";
    }
    
    public String eliminarAnimal(int indice) {
        if(indice >= 0 && indice < numAnimales) {
            for(int i = indice; i < numAnimales - 1; i++) {
                animales[i] = animales[i + 1];
            }
            animales[numAnimales - 1] = null;
            numAnimales--;
            return "Animal eliminado correctamente";
        }
        return "Índice no válido";
    }
    
    public String vaciarInventario() {
        for(int i = 0; i < numAnimales; i++) {
            animales[i] = null;
        }
        numAnimales = 0;
        return "Inventario vaciado";
    }
}