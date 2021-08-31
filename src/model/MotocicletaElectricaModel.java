package model;

public class MotocicletaElectricaModel extends  Vehiculo{
    private int autonomia;
    private String provMotorfk;
    
    public MotocicletaElectricaModel(String fabricanteMoto, int precioUnitarioMoto, int autonomia, String provMotorfk){
        super(fabricanteMoto, precioUnitarioMoto);
        this.autonomia          = autonomia;
        this.provMotorfk        = provMotorfk;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public String getProvMotorfk() {
        return provMotorfk;
    }

    public void setProvMotorfk(String provMotorfk) {
        this.provMotorfk = provMotorfk;
    }
}
