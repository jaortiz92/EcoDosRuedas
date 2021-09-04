
package model;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//Creación de la clase IntencionCompraModel de acuerdo a las caracteristicas de la base de datos
public class IntencionCompraModel {
    private int codigoCompra;
    private ClienteModel aliasComprafk;
    private Vehiculo fabComprafk;
    private Timestamp fechaCompra;
    private String stringfecha;
    private SimpleDateFormat formatoFecha;
    
    //Creación del metodo constructor
    public IntencionCompraModel(int codigoCompra, ClienteModel aliasComprafk, Vehiculo fabComprafk, String fechaCompra){
        formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.codigoCompra    = codigoCompra;
        this.aliasComprafk   = aliasComprafk;
        this.fabComprafk = fabComprafk;
        this.stringfecha = fechaCompra;
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
        formatoFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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

    public Timestamp getFechaCompra() {
        return fechaCompra;
    }

    public String getStringfecha() {
        return stringfecha;
    }

    public void setFechaCompra(String fechaCompra) {
        java.util.Date fechaJava = null;
        try {
            fechaJava = formatoFecha.parse(fechaCompra);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long fechaEnMilisegundos = fechaJava.getTime();
        this.fechaCompra = new Timestamp(fechaEnMilisegundos);
    }

    public void setFechaCompra() {
        java.util.Date fechaJava = new java.util.Date();
        long fechaEnMilisegundos = fechaJava.getTime();
        this.fechaCompra = new Timestamp(fechaEnMilisegundos);
    }
}
