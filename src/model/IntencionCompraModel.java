
package model;

import java.sql.Date;

//Creación de la clase IntencionCompraModel de acuerdo a las caracteristicas de la base de datos
public class IntencionCompraModel {
    private int codigoCompra;
    private ClienteModel aliasComprafk;
    private Vehiculo fabComprafk;
    private Date fechaCompra; 
    
    //Creación del metodo constructor
    public IntencionCompraModel(int codigoCompra, ClienteModel aliasComprafk, Vehiculo fabComprafk, String fechaCompra){
        this.codigoCompra    = codigoCompra;
        this.aliasComprafk   = aliasComprafk;
        this.fabComprafk = fabComprafk;
        setFechaCompra(fechaCompra);
    }
    //Sobrecargas del metodo constructor
    public IntencionCompraModel(int codigoCompra, ClienteModel aliasComprafk, Vehiculo fabComprafk){
        this.codigoCompra    = codigoCompra;
        this.aliasComprafk   = aliasComprafk;
        this.fabComprafk = fabComprafk;
        setFechaCompra();
    }

    public IntencionCompraModel(ClienteModel aliasComprafk, Vehiculo fabComprafk, String fechaCompra){
        this.codigoCompra    = 0;
        this.aliasComprafk   = aliasComprafk;
        this.fabComprafk = fabComprafk;
        setFechaCompra(fechaCompra);
    }

    public IntencionCompraModel(ClienteModel aliasComprafk, Vehiculo fabComprafk){
        this.codigoCompra    = 0;
        this.aliasComprafk   = aliasComprafk;
        this.fabComprafk = fabComprafk;
        setFechaCompra();
    }

    //Getters y Setters
    public int getCodigoCompra() {
        return codigoCompra;
    }

    public void setCodigoCompra(int codigoCompra) {
        this.codigoCompra = codigoCompra;
    }

    public ClienteModel getAliasComprafk() {
        return aliasComprafk;
    }

    public void setAliasComprafk(ClienteModel aliasComprafk) {
        this.aliasComprafk = aliasComprafk;
    }

    public Vehiculo getFabComprafk() {
        return fabComprafk;
    }

    public void setFabComprafk(Vehiculo fabComprafk) {
        this.fabComprafk = fabComprafk;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        // yyyy/MM/dd
        int year = Integer.parseInt(fechaCompra.substring(0, 4));
        int month = Integer.parseInt(fechaCompra.substring(5, 7));
        int day = Integer.parseInt(fechaCompra.substring(8, 10));
        int hour = Integer.parseInt(fechaCompra.substring(11, 13));
        int min = Integer.parseInt(fechaCompra.substring(14, 16));
        int sec = Integer.parseInt(fechaCompra.substring(17, 19));

        java.util.Date fechaJava = new java.util.Date(year, month, day, hour, min, sec);
        long fechaEnMilisegundos = fechaJava.getTime();
        this.fechaCompra = new Date(fechaEnMilisegundos);
    }

    public void setFechaCompra() {
        // yyyy/MM/dd
        java.util.Date fechaJava = new java.util.Date();
        long fechaEnMilisegundos = fechaJava.getTime();
        this.fechaCompra = new Date(fechaEnMilisegundos);
    }
}


