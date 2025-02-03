import java.util.regex.Pattern;

class Contacto {
    private String nombre;
    private String telefono;
    private String correo;
    
    private Pattern patron_nombre = Pattern.compile("[A-Z][a-zA-Z]*");
    private Pattern patron_tfno = Pattern.compile("[679]\\d{8}");
    private Pattern patron_correo = Pattern.compile("[a-zA-Z0-9.*-]+@[a-z]+\\.[a-z]{2,4}");

    public Contacto(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (validar(1, nombre)) {
            this.nombre = nombre;
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (validar(2, telefono)) {
            this.telefono = telefono;
        }
    }

    public String getCorreo() {
        return correo;
    }                                                   

    public void setCorreo(String correo) {
        if (validar(3, correo)) {
            this.correo = correo;
        }
    }
    

    public boolean validar(int op, String texto){
        switch(op){
            case 1:
                return patron_nombre.matcher(nombre).matches();
            case 2:
                return patron_tfno.matcher(telefono).matches();
            case 3:
                return patron_correo.matcher(correo).matches();
            default:
                return false;
        }
    }

}