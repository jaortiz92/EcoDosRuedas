package model;

//Creación de la Superclase Vehiculo
public class Vehiculo {
    private String fabricante;
    private int precioUnitario;
    
    /*
    * Creación del metodo constructor usando las caracteristicas que comparten
    * las clases BicicletaModel y MotocicletaElectricaModel
    */
    public Vehiculo(String fabricante, int precioUnitario){
        this.fabricante     = fabricante;
        this.precioUnitario = precioUnitario;
    }

    public Vehiculo(String fabricante){
        this.fabricante     = fabricante;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(int precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String stringFabricante(){
        return "Vehiculo: " + fabricante;
    }
}
