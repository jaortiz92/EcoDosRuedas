package access;

import model.IntencionCompraModel;
import utils.ConeccionDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
                JOptionPane.showMessageDialog(null, "El Cliente fue ingresado");
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cliente no agregado\nError: " + e);
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
                JOptionPane.showMessageDialog(null, "El Cliente fue ingresado");
            }
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Cliente no agregado\nError: " + e);
        }
    }

    public ArrayList<IntencionCompraModel> leerIntencionCompra(){
        ArrayList<IntencionCompraModel> intencionesCompra = new ArrayList<>();

        return intencionesCompra;
    }

    public void modificarIntencionCompra(){

    }

    public void eliminarIntencionCompra(int id, String Alias) {
        try {
            if (connection == null) {
                connection = ConeccionDB.getConeccion();
            }
            String sql = "DELETE FROM intencion_de_compra WHERE codigo=? AND alias_fk=?;";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, Alias);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "La motocicleta fue borrada exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
}
