package Model;

/**
 *
 * @author David
 */
public class BicicletaModel {
    private String FabricanteBici;
    private String /*o int*/ PrecioUnitarioBici;
    private int /*o String*/ Año;
    
    
    public BicicletaModel(String FabricanteBici, String PrecioUnitarioBici, int Año){
        this.FabricanteBici     = FabricanteBici;
        this.PrecioUnitarioBici = PrecioUnitarioBici;
        this.Año                = Año;
    }
    
    /*Mirar cuales getters y setters crear y como crear el toString*/
}