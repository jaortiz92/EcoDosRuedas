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
public class IntencionCompraModel {
    private int    CodigoCompra;/* Revisar si se usa un autoincrement dependiendo de lo que se vaya a hacer*/
    private String AliasComprafk;
    private String FabBiciComprafk;
    private String FabMotoComprafk;
    private String FechaCompra;
    
    public IntencionCompraModel(int CodigoCompra, String AliasComprafk, String FabBiciComprafk, String FabMotoComprafk, String FechaCompra){
        this.CodigoCompra    = CodigoCompra;
        this.AliasComprafk   = AliasComprafk;
        this.FabBiciComprafk = FabBiciComprafk;
        this.FabMotoComprafk = FabMotoComprafk;
        this.FechaCompra     = FechaCompra;
    }
    /*Mirar cuales getters y setters crear y como crear el toString*/
}


