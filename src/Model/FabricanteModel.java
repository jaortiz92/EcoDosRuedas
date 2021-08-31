
package Model;

public class FabricanteModel {
    private String provMotor;
    private String provDireccion;
    private String provTelefono;
    
    public FabricanteModel(String provMotor, String provDireccion, String provTelefono){
        this.provMotor      = provMotor;
        this.provDireccion  = provDireccion;
        this.provTelefono   = provTelefono;
    }

    public String getProvMotor() {
        return provMotor;
    }

    public void setProvMotor(String provMotor) {
        this.provMotor = provMotor;
    }

    public String getProvDireccion() {
        return provDireccion;
    }

    public void setProvDireccion(String provDireccion) {
        this.provDireccion = provDireccion;
    }

    public String getProvTelefono() {
        return provTelefono;
    }

    public void setProvTelefono(String provTelefono) {
        this.provTelefono = provTelefono;
    }
}

