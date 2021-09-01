package model;

import java.sql.Date;

public class ClienteModel {
    private String alias;
    private String nombre;
    private String apellido;
    private String email;
    private String celular; // String?
    private String contrasena;
    private Date fechaNacimiento;
    
    public ClienteModel(String alias, String nombre, String apellido, String email, String celular, String contrasena, String fechaNacimiento){
        this.alias           = alias;
        this.nombre          = nombre;
        this.apellido        = apellido;
        this.email           = email;
        this.celular         = celular;
        this.contrasena      = contrasena;
        setFechaNacimiento(fechaNacimiento);
    }

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

    public void setFechaNacimiento(String fechaNacimiento) {
        // yyyy/MM/dd
        int year = Integer.valueOf(fechaNacimiento.substring(0, 4));
        int month = Integer.valueOf(fechaNacimiento.substring(5, 7));
        int day = Integer.valueOf(fechaNacimiento.substring(8, 10));
        Date date = new Date( year - 1900 , month - 1, day);
        this.fechaNacimiento = date;
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
