package Model;

public class MotocicletaElectricaModel {
    private String fabricanteMoto;
    private int precioUnitarioMoto;
    private int autonomia;
    private String provMotorfk;
    
    public MotocicletaElectricaModel(String fabricanteMoto, int precioUnitarioMoto, int autonomia, String provMotorfk){
        this.fabricanteMoto     = fabricanteMoto;
        this.precioUnitarioMoto = precioUnitarioMoto;
        this.autonomia          = autonomia;
        this.provMotorfk        = provMotorfk;
    }

    public String getFabricanteMoto() {
        return fabricanteMoto;
    }

    public void setFabricanteMoto(String fabricanteMoto) {
        this.fabricanteMoto = fabricanteMoto;
    }

    public int getPrecioUnitarioMoto() {
        return precioUnitarioMoto;
    }

    public void setPrecioUnitarioMoto(int precioUnitarioMoto) {
        this.precioUnitarioMoto = precioUnitarioMoto;
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
