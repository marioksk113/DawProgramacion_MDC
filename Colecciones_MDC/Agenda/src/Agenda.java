import java.util.LinkedList;

class Agenda {
    private LinkedList<Contacto> contactos;

    public Agenda() {
        contactos = new LinkedList<>();
    }

    public int añadirContacto(String nombre, String telefono, String correo) {
        Contacto nuevoContacto = new Contacto(nombre, telefono, correo);

        if (!nuevoContacto.validar(1,nombre)) {
            return 1;
        }
        if (!nuevoContacto.validar(2,telefono)) {
            return 2;
        }
        if (!nuevoContacto.validar(3,correo)) {
            return 3;
        }
        for (Contacto c : contactos) {
            if (c.getNombre().equals(nombre)) {
                return 4;
            }
        }

        contactos.add(nuevoContacto);
        return 0;
    }

    public Contacto buscarContacto(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equals(nombre)) {
                return c;
            }
        }
        return null;
    }

    public boolean eliminarContacto(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equals(nombre)) {
                contactos.remove(c);
                return true;
            }
        }
        return false;
    }

    public LinkedList<Contacto> obtenerContactos() {
        return new LinkedList<>(contactos);
    }

    public boolean agendaVacia() {
        return contactos.isEmpty();
    }

    public int numeroContactos() {
        return contactos.size();
    }
}