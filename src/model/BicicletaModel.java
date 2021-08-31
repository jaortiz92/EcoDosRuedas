package model;

public class BicicletaModel extends Vehiculo{
    private String fabricanteBici;
    private int precioUnitarioBici;
    private int ano;
    
    
    public BicicletaModel(String fabricanteBici, int precioUnitarioBici, int ano){
        super(fabricanteBici, precioUnitarioBici);
        this.ano = ano;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}