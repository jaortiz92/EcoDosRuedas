package model;

public class ProveedorMotor {
    String nombreProveedor;
    String direccion;
    String telefono;

    public ProveedorMotor(String nombreProveedor, String direccion, String telefono) {
        this.nombreProveedor = nombreProveedor;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
