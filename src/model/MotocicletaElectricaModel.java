package model;


//Creación de la clase MotoclicletaElectricaModel de acuerdo a las caracteristicas de la base de datos
public class MotocicletaElectricaModel extends  Vehiculo{
    private int autonomia;
    private String provMotorfk;
    
    // Creación del metodo constructor
    public MotocicletaElectricaModel(String fabricanteMoto, int precioUnitarioMoto, int autonomia, String provMotorfk){
        super(fabricanteMoto, precioUnitarioMoto);
        this.autonomia          = autonomia;
        this.provMotorfk        = provMotorfk;
    }
    
    //Getters y Setters
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

    @Override
    public String stringFabricante(){
        return "Motocicleta Electrica: " + getFabricante();
    }
}
