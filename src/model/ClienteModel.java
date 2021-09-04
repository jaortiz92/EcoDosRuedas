package model;

import java.sql.Date;

//Creación de la clase Cliente de acuerdo a las caracteristicas de la base de datos
public class ClienteModel {
    //Inicialización de los atributos
    private String alias;
    private String nombre;
    private String apellido;
    private String email;
    private String celular;
    private String contrasena;
    private Date fechaNacimiento;
    
    //Creación del metodo constructor
    public ClienteModel(String alias, String nombre, String apellido, String email, String celular, String contrasena, String fechaNacimiento){
        this.alias           = alias;
        this.nombre          = nombre;
        this.apellido        = apellido;
        this.email           = email;
        this.celular         = celular;
        this.contrasena      = contrasena;
        setFechaNacimiento(fechaNacimiento);
    }
    //Getters y Setters
    public ClienteModel(String alias){
        this.alias = alias;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }
    //Conversión de la fecha de nacimiento a tipo Date
    public void setFechaNacimiento(String fechaNacimiento) {
        int year = Integer.parseInt(fechaNacimiento.substring(0, 4));
        int month = Integer.parseInt(fechaNacimiento.substring(5, 7));
        int day = Integer.parseInt(fechaNacimiento.substring(8, 10));
        Date date = new Date( year - 1900 , month - 1, day);
        this.fechaNacimiento = date;
    }

    public String stringAlias(){
        return alias + ": " + nombre + " " + apellido;
    }

    @Override
    public String toString() {
        return "ClienteModel{" +
                "alias='" + alias + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}
