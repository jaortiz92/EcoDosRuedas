/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author David
 */
public class MotocicletaElectricaModel {
    private String FabricanteMoto;
    private String /*o int*/ PrecioUnitarioMoto;
    private String Autonomia;
    private String ProvMotorfk;
    
    public MotocicletaElectricaModel(String FabricanteMoto, String PrecioUnitarioMoto, String Autonomia, String ProvMotorfk){
        this.FabricanteMoto     = FabricanteMoto;
        this.PrecioUnitarioMoto = PrecioUnitarioMoto;
        this.Autonomia          = Autonomia;
        this.ProvMotorfk        = ProvMotorfk;
    }
    /*Mirar cuales getters y setters crear y como crear el toString*/
}
