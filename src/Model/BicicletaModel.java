package Model;

public class BicicletaModel {
    private String fabricanteBici;
    private int precioUnitarioBici;
    private int ano;
    
    
    public BicicletaModel(String fabricanteBici, int precioUnitarioBici, int ano){
        this.fabricanteBici     = fabricanteBici;
        this.precioUnitarioBici = precioUnitarioBici;
        this.ano                = ano;
    }

    public String getFabricanteBici() {
        return fabricanteBici;
    }

    public void setFabricanteBici(String fabricanteBici) {
        this.fabricanteBici = fabricanteBici;
    }

    public int getPrecioUnitarioBici() {
        return precioUnitarioBici;
    }

    public void setPrecioUnitarioBici(int precioUnitarioBici) {
        this.precioUnitarioBici = precioUnitarioBici;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}