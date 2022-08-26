public class FormatOfRegisters {
    private String nombre;
    private String apellidos;
    private String direccion;
    private String numeroTelefonico;
    private String correoElectronico;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        System.out.println("Introduce tu nombre");
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        System.out.println("Introduce tus Apellidos");
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        System.out.println("Introduce tu Direccion");
        this.direccion = direccion;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        System.out.println("Introduce tu numero telefonico");
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        System.out.println("Introduce tu correo Electronico");
        this.correoElectronico = correoElectronico;
    }

    public String registerComplete(String line){
        line = getNombre() + getApellidos() + getCorreoElectronico() + getDireccion() + getNumeroTelefonico();
        return line;
    }
}
