
package model;

import java.sql.Date;
//import java.util.Date;

public class IntencionCompraModel {
    private int codigoCompra;/* Revisar si se usa un autoincrement dependiendo de lo que se vaya a hacer*/
    private ClienteModel aliasComprafk;
    private Vehiculo fabComprafk;
    private Date fechaCompra; // Date
    
    public IntencionCompraModel(int codigoCompra, ClienteModel aliasComprafk, Vehiculo fabComprafk, String fechaCompra){
        this.codigoCompra    = codigoCompra;
        this.aliasComprafk   = aliasComprafk;
        this.fabComprafk = fabComprafk;
        setFechaCompra(fechaCompra);
    }

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
        int year = Integer.valueOf(fechaCompra.substring(0, 4));
        int month = Integer.valueOf(fechaCompra.substring(5, 7));
        int day = Integer.valueOf(fechaCompra.substring(8, 10));
        int hour = Integer.valueOf(fechaCompra.substring(11, 13));
        int min = Integer.valueOf(fechaCompra.substring(14, 16));
        int sec = Integer.valueOf(fechaCompra.substring(17, 19));

        java.util.Date fechaJava = new java.util.Date(year, month, day, hour, min, sec);
        long fechaEnMilisegundos = fechaJava.getTime();
        Date fechaSql = new Date(fechaEnMilisegundos);
        this.fechaCompra = fechaSql;
    }

    public void setFechaCompra() {
        // yyyy/MM/dd
        java.util.Date fechaJava = new java.util.Date();
        long fechaEnMilisegundos = fechaJava.getTime();
        Date fechaSql = new Date(fechaEnMilisegundos);
        this.fechaCompra = fechaSql;
    }
}


