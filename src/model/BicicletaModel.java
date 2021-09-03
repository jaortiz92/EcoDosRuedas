package model;


//Creación de la clase Bicicleta de acuerdo a los atributos de la base de datos
public class BicicletaModel extends Vehiculo{
    private String fabricanteBici;
    private int precioUnitarioBici;
    private int ano;
    
    // Creación del metodo constructor
    public BicicletaModel(String fabricanteBici, int precioUnitarioBici, int ano){
        super(fabricanteBici, precioUnitarioBici);
        this.ano = ano;
    }
    
    //Getters y Setters
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}