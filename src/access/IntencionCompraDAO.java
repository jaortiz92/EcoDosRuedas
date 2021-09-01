package access;

import model.ClienteModel;
import model.IntencionCompraModel;
import model.MotocicletaElectricaModel;
import model.Vehiculo;
import utils.ConeccionDB;

import javax.swing.*;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class IntencionCompraDAO {
    private Connection connection = null;

    public void insertarIntencionCompraBici(IntencionCompraModel intencionCompra){
        try {
            if (connection == null) {
                connection = ConeccionDB.getConeccion();
            }
            String sql = "INSERT INTO intencion_de_compra(alias_fk, fabricante_bici_fk, fecha) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, intencionCompra.getAliasComprafk().getAlias());
            statement.setString(2, intencionCompra.getFabComprafk().getFabricante());
            statement.setDate(3, intencionCompra.getFechaCompra());

            int lineasInsertadas = statement.executeUpdate();
            if (lineasInsertadas > 0) {
                JOptionPane.showMessageDialog(null, "La intencion de compra fue ingresada");
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "La intencion de compra no fue ingresada\nError: " + e);
        }
    }

    public void insertarIntencionCompraMoto(IntencionCompraModel intencionCompra){
        try {
            if (connection == null) {
                connection = ConeccionDB.getConeccion();
            }
            String sql = "INSERT INTO intencion_de_compra(alias_fk, fabricante_moto_fk, fecha) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, intencionCompra.getAliasComprafk().getAlias());
            statement.setString(2, intencionCompra.getFabComprafk().getFabricante());
            statement.setDate(3, intencionCompra.getFechaCompra());

            int lineasInsertadas = statement.executeUpdate();
            if (lineasInsertadas > 0) {
                JOptionPane.showMessageDialog(null, "La intencion de compra fue ingresada");
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "La intencion de compra no fue ingresada\nError: " + e);
        }
    }

    public ArrayList<IntencionCompraModel> leerIntencionCompra(){
        ArrayList<IntencionCompraModel> intencionesCompra = new ArrayList<>();
        try {
            if (connection == null) {
                connection = ConeccionDB.getConeccion();
            }
            String sql = "SELECT * FROM intencion_de_compra";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()){
                Vehiculo vehiculo;
                if (result.getString(3).equalsIgnoreCase("null")){
                    vehiculo = new Vehiculo(result.getString(4));
                } else {
                    vehiculo = new Vehiculo(result.getString(3));
                }

                IntencionCompraModel intencionCompra = new IntencionCompraModel(
                        result.getInt(1),
                        new ClienteModel(result.getString(2)),
                        vehiculo,
                        result.getString(5)
                );
                intencionesCompra.add(intencionCompra);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "La tabla intencion de compra genero error\nError: " + e);
        }

        return intencionesCompra;
    }

    public void modificarIntencionCompra(){

    }

    public void eliminarIntencionCompra(){

    }
}
