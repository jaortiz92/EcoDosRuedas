package Model;

public class ClienteModel {
    private String alias;
    private String nombre;
    private String apellido;
    private String email;
    private String celular; // String?
    private int contrasena;
    private String fechaNacimiento;
    
    public ClienteModel(String alias, String nombre, String apellido, String email, String celular, int contrasena, String fechaNacimiento){
        this.alias           = alias;
        this.nombre          = nombre;
        this.apellido        = apellido;
        this.email           = email;
        this.celular         = celular;
        this.contrasena      = contrasena;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public int getContrasena() {
        return contrasena;
    }

    public void setContrasena(int contrasena) {
        this.contrasena = contrasena;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
