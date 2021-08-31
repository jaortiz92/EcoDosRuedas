
package model;

public class IntencionCompraModel {
    private int    codigoCompra;/* Revisar si se usa un autoincrement dependiendo de lo que se vaya a hacer*/
    private String aliasComprafk; //Fk?
    private String fabBiciComprafk;
    private String fabMotoComprafk;
    private String fechaCompra; // Date
    
    public IntencionCompraModel(int codigoCompra, String aliasComprafk, String fabBiciComprafk, String fabMotoComprafk, String fechaCompra){
        this.codigoCompra    = codigoCompra;
        this.aliasComprafk   = aliasComprafk;
        this.fabBiciComprafk = fabBiciComprafk;
        this.fabMotoComprafk = fabMotoComprafk;
        this.fechaCompra     = fechaCompra;
    }

    public int getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public String getAliasComprafk() {
        return aliasComprafk;
    }

    public void setAliasComprafk(String aliasComprafk) {
        this.aliasComprafk = aliasComprafk;
    }

    public String getFabBiciComprafk() {
        return fabBiciComprafk;
    }

    public void setFabBiciComprafk(String fabBiciComprafk) {
        this.fabBiciComprafk = fabBiciComprafk;
    }

    public String getFabMotoComprafk() {
        return fabMotoComprafk;
    }

    public void setFabMotoComprafk(String fabMotoComprafk) {
        this.fabMotoComprafk = fabMotoComprafk;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}


